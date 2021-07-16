package vn.co.vis.web.service;

import org.springframework.http.ResponseEntity;
import vn.co.vis.web.dto.request.FolderRequest;
import vn.co.vis.web.dto.request.NoteRequest;
import vn.co.vis.web.dto.response.FolderResponse;
import vn.co.vis.web.dto.response.NoteResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface NoteService {
    Optional<List<NoteResponse>> getNoteByFolderId(HttpServletRequest httpServletRequest, String folderId, String userId);

    Optional<List<NoteResponse>> getNoteByContentId(HttpServletRequest httpServletRequest, String contentId, String userId);



    Optional<NoteResponse> getNote(HttpServletRequest httpServletRequest, String id, String userId);

    ResponseEntity<String> deleteNote(HttpServletRequest httpServletRequest, String id);

    Optional<NoteResponse>  insertNote(HttpServletRequest httpServletRequest, NoteRequest noteRequest);

    ResponseEntity<NoteResponse> updateNote(HttpServletRequest httpServletRequest, NoteRequest noteRequest);
}
