package vn.co.vis.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.repository.FolderRepository;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.exception.ResourceNotFoundException;
import vn.co.vis.restful.service.AbstractService;
import vn.co.vis.restful.service.FolderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FolderServiceImpl  extends AbstractService implements FolderService {
    @Autowired
    FolderRepository folderRepository;
    @Override
    public Optional<List<FolderResponse>> getFolder(String id, String userId) {
        List<Folder> folders = folderRepository.findById(id,userId).orElseThrow(() -> {
            throw new ResourceNotFoundException();
        });
        return Optional.of(folders.stream()
                .map(folder -> new FolderResponse(folder.getId(),
                        folder.getName(),folder.getDate(),
                        folder.getFolderId(),folder.getUserId()))
                .collect(Collectors.toList()));
    }

    @Override
    public String deleteFolder(String id) {
        System.out.println("hi");
        String  folderResponse = folderRepository.deleteById(id);
        return folderResponse ;
    }
}
