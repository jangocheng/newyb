package com.yiban.erp.controller.file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yiban.erp.entities.FileInfo;
import com.yiban.erp.entities.FileType;
import com.yiban.erp.entities.User;
import com.yiban.erp.exception.BizException;
import com.yiban.erp.exception.ErrorCode;
import com.yiban.erp.service.file.FileService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 档案管理
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/filetype/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> fileTypeList(@AuthenticationPrincipal User user) throws Exception {
        List<FileType> types = fileService.getFileTypeList(user.getCompanyId());
        return ResponseEntity.ok().body(JSON.toJSONString(types));
    }

    @RequestMapping(value = "/filetype/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addFileType(@RequestBody FileType fileType,
                                              @AuthenticationPrincipal User user) throws Exception {
        logger.info("user:{} request add file type:{}", user.getId(), fileType.getTypeName());
        FileType result = fileService.addFileType(user, fileType.getTypeName());
        if (result != null && result.getId() > 0) {
            List<FileType> types = fileService.getFileTypeList(user.getCompanyId());
            return ResponseEntity.ok().body(JSON.toJSONString(types));
        }else {
            logger.warn("user:{} request to add file type {} fail.", user.getId(), fileType.getTypeName());
            throw new BizException(ErrorCode.FILE_TYPE_CREATE_FAIL);
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> list(@RequestParam(value = "page", required = false) Integer page,
                                       @RequestParam(value = "size", required = false) Integer size,
                                       @RequestParam(value = "fileType", required = false) String fileType,
                                       @RequestParam(value = "fileName", required = false) String fileName,
                                       @AuthenticationPrincipal User user) throws Exception {

        logger.debug("user:{} request file info list by params: {} {} {} {}",
                user.getId(), page, size, fileType, fileName);
        List<FileInfo> fileInfos = fileService.getList(user.getCompanyId(), fileType, fileName, page, size);
        int count = 0;
        if (!fileInfos.isEmpty()) {
            count = fileService.getListCount(user.getCompanyId(), fileType, fileName);
        }
        JSONObject result = new JSONObject();
        result.put("count", count);
        result.put("data", fileInfos);
        return ResponseEntity.ok().body(result.toJSONString());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> add(@RequestBody FileInfo fileInfo,
                                      @AuthenticationPrincipal User user) throws Exception {
        logger.info("user:{} request add file info.", user.getId());
        FileInfo result = fileService.addFileInfo(user, fileInfo);
        return ResponseEntity.ok().body(JSON.toJSONString(result));
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> removeFileInfo(@RequestBody String reqData,
                                                 @AuthenticationPrincipal User user) throws Exception {
        logger.info("user:{} request remove file info. reqData:{}", user.getId(), reqData);
        List<Integer> ids = JSON.parseArray(reqData, Integer.class);
        int count = fileService.removeFileInfo(user, ids);
        JSONObject result = new JSONObject();
        result.put("count", count);
        return ResponseEntity.ok().body(result.toJSONString());
    }

    @RequestMapping(value = "/upload/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> uploadFile(HttpServletRequest request,
                                             @AuthenticationPrincipal User user) throws Exception {
        MultipartHttpServletRequest mtRequest = (MultipartHttpServletRequest) request;
        String fileInfoId = mtRequest.getParameter("fileId");
        if (StringUtils.isBlank(fileInfoId) || !StringUtils.isNumeric(fileInfoId)) {
            logger.warn("user:{} request upload file but fileId:{} is error.", user.getId(), fileInfoId);
            throw new BizException(ErrorCode.FILE_UPLOAD_PARAMS_ERROR);
        }
        Integer fileId = Integer.parseInt(fileInfoId);
        String comment = mtRequest.getParameter("comment");
        MultipartFile file = mtRequest.getFile("file");
        if (file == null || file.isEmpty()) {
            logger.warn("user:{} request upload file but file is empty.", user.getId());
            throw new BizException(ErrorCode.FILE_UPLOAD_PARAMS_ERROR);
        }
        String url = fileService.saveFile(user, fileId, comment, file);
        logger.info("user:{} upload file success, file url:{}", user.getId(), url);
        JSONObject result = new JSONObject();
        result.put("url", url);
        return ResponseEntity.ok().body(result.toJSONString());
    }

    @RequestMapping(value = "/upload/remove", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeLocationFile(@RequestBody String reqData,
                                                     @AuthenticationPrincipal User user) throws Exception {
        logger.info("user:{} request to remove location file. params:{}", user.getId(), reqData);
        JSONObject data = JSON.parseObject(reqData);
        Integer uploadId = data.getInteger("fileUploadId");
        if (uploadId == null) {
            logger.warn("user:{} request to remove location file but request params id is null.", user.getId());
            throw new BizException(ErrorCode.FILE_UPLOAD_REMOVE_PARAMS);
        }
        fileService.deleteFileUpload(user, uploadId);
        return ResponseEntity.ok().build();
    }

}
