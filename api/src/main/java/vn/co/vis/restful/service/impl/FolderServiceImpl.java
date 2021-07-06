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
    public Optional<FolderResponse> getFolder(String id) {
        Optional<FolderResponse>  folderResponse = folderRepository.findById(id);
        return folderResponse ;
    }

    @Override
    public Optional<List<FolderResponse>> getFoldersById(String id, String userId) {
        List<Folder> folders = folderRepository.findByIdParentFolder(id,userId).orElseThrow(() -> {
            throw new ResourceNotFoundException();
        });
        return Optional.of(folders.stream()
                .map(folder -> new FolderResponse(folder.getId(),
                        folder.getName(),folder.getDate(),
                        folder.getFolderId(),folder.getUserId()))
                .collect(Collectors.toList()));
    }

    @Override
    public  Optional<String> deleteFolder(String id) {
        String  folderResponse = folderRepository.deleteById(id);
        return Optional.of(folderResponse) ;
    }

    @Override
    public Optional<FolderResponse> insertFolder(Folder folder) {
        Optional<FolderResponse>  folderResponse = folderRepository.insert(folder);
        return folderResponse ;

    }

    @Override
    public Optional<FolderResponse> updateFolder(String id, Folder folder) {
        Optional<FolderResponse>  folderResponse = folderRepository.update(id, folder);
        return folderResponse ;
    }
}
