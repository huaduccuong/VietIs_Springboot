package vn.co.vis.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.User;
import vn.co.vis.restful.dao.repository.FolderRepository;
import vn.co.vis.restful.dao.repository.UserRepository;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.dto.response.UserResponse;
import vn.co.vis.restful.exception.ResourceNotFoundException;
import vn.co.vis.restful.service.AbstractService;
import vn.co.vis.restful.service.FolderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FolderServiceImpl  extends AbstractService implements FolderService {
    @Autowired
    FolderRepository folderRepository;
    @Override
    public Optional<List<FolderResponse>> getFolder(String id, String userId) {
        List<Folder> folders = folderRepository.findById(id,userId).orElseThrow(() -> {
            throw new ResourceNotFoundException();
        });
        return Optional.of(folders.stream()
                .map(folder -> new FolderResponse(folder.getFolderId(),
                        folder.getName(),folder.getDate(),
                        folder.getFolderId(),folder.getUserId()))
                .collect(Collectors.toList()));
    }
}
