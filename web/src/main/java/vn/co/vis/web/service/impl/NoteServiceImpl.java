package vn.co.vis.web.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.co.vis.web.dto.request.NoteRequest;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.dto.response.NoteResponse;
import vn.co.vis.web.service.AbstractService;
import vn.co.vis.web.service.NoteService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class NoteServiceImpl extends AbstractService implements NoteService {


    @Override
    public Optional<List<NoteResponse>> getNoteByFolderId(HttpServletRequest httpServletRequest, String folderId, String userId) {
        NoteResponse[] responses = apiExchangeService.get(httpServletRequest, apiExchangeService.createURL(backApiUrl, "/note/folder/", folderId, userId), NoteResponse[].class);
        if (responses == null || responses.length == 0) {
            return Optional.empty();
        }
        return Optional.of(Arrays.asList(responses));
    }

    @Override
    public Optional<List<NoteResponse>> getNoteByContentId(HttpServletRequest httpServletRequest, String contentId, String userId) {
        NoteResponse[] responses = apiExchangeService.get(httpServletRequest, apiExchangeService.createURL(backApiUrl, "/note/content", contentId, userId), NoteResponse[].class);
        if (responses == null || responses.length == 0) {
            return Optional.empty();
        }
        return Optional.of(Arrays.asList(responses));
    }

    @Override
    public Optional<NoteResponse> getNote(HttpServletRequest httpServletRequest, String id, String userId) {
        NoteResponse response
                = apiExchangeService.get(httpServletRequest, apiExchangeService.createURL(backApiUrl, "note", id,userId), NoteResponse.class);
        if (response == null) {
            return Optional.empty();
        }
        return Optional.of(response);
    }

    @Override
    public ResponseEntity<String> deleteNote(HttpServletRequest httpServletRequest, String id) {
        ResponseEntity<String> response = apiExchangeService.delete(httpServletRequest,backApiUrl + "/note/" + id,null,String.class);
        return response;
    }

    @Override
    public Optional<NoteResponse> insertNote(HttpServletRequest httpServletRequest, NoteRequest noteRequest) {
        NoteResponse response = apiExchangeService.post(httpServletRequest, backApiUrl + "/note", noteRequest, NoteResponse.class);
        return Optional.of(response);
    }

    @Override
    public ResponseEntity<NoteResponse> updateNote(HttpServletRequest httpServletRequest, NoteRequest noteRequest) {
        String id = String.valueOf(noteRequest.getId());
        ResponseEntity<NoteResponse> response = apiExchangeService.put(httpServletRequest,backApiUrl + "/note/"+id,noteRequest,NoteResponse.class);
        return response;
    }
}
