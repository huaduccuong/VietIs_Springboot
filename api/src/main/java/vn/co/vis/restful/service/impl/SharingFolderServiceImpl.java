package vn.co.vis.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.SharingFolder;
import vn.co.vis.restful.dao.repository.SharingFolderRepository;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.dto.response.SharingFolderResponse;
import vn.co.vis.restful.exception.ResourceNotFoundException;
import vn.co.vis.restful.service.AbstractService;
import vn.co.vis.restful.service.SharingFolderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class SharingFolderServiceImpl extends AbstractService implements SharingFolderService {
    @Autowired
    SharingFolderRepository sharingFolderRepository;
    @Override
    public Optional<SharingFolderResponse> getSharingFolder(String userId) {
        Optional<SharingFolderResponse> sharingFolder = sharingFolderRepository.findSharingFolder(userId);
//        SharingFolderResponse sharingFolderResponse = new SharingFolderResponse();
//        sharingFolderResponse.setFolderList(sharingFolder.get().getFolderList());
//        sharingFolderResponse.setUsers(null);
        return sharingFolder ;
    }

    @Override
    public Optional<SharingFolderResponse> insertSharingFolder(SharingFolder sharingFolder) {
        return Optional.empty();
    }
}
