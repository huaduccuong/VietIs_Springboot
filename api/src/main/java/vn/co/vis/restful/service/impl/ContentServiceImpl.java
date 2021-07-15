package vn.co.vis.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.co.vis.restful.dao.entity.Content;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.repository.ContentRepository;
import vn.co.vis.restful.dao.repository.FolderRepository;
import vn.co.vis.restful.dto.response.ContentResponse;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.exception.ResourceNotFoundException;
import vn.co.vis.restful.service.AbstractService;
import vn.co.vis.restful.service.ContentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ContentServiceImpl extends AbstractService implements ContentService {
    @Autowired
    ContentRepository contentRepository;
    @Override
    public Optional<ContentResponse> getContent(String id) {
        Optional<ContentResponse>  contentResponse = contentRepository.getContent(id);
        return contentResponse ;
    }

    @Override
    public Optional<List<ContentResponse>> getContentsByFolderId(String id) {
        List<ContentResponse> contents = contentRepository.getContentsByFolderId(id).orElseThrow(() -> {
            throw new ResourceNotFoundException();
        });
        return Optional.of(contents.stream()
                .map(content -> new ContentResponse(content.getId(),
                        content.getName(),content.getDescription(),
                        content.getDate(),content.getFormat(),content.getFolderId(),content.getUrl()))
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<String> deleteContent(String id) {
        String  contentResponse = contentRepository.deleteContent(id);
        return Optional.of(contentResponse) ;
    }

    @Override
    public Optional<ContentResponse> insertContent(Content content) {
        Optional<ContentResponse>  contentResponse = contentRepository.insertContent(content);
        return contentResponse ;
    }

//    @Override
//    public Optional<ContentResponse> updateContent(String id, Content content) {
//        return Optional.empty();
//    }
}
