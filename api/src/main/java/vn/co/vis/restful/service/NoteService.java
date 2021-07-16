package vn.co.vis.restful.service;

import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.Note;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.dto.response.NoteResponse;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    Optional<NoteResponse> getNote(String id, String userId);
    Optional<List<NoteResponse>> getNotesByFolderId(String folderId, String userId);
    Optional<List<NoteResponse>> getNotesByContentId(String contentId, String userId);
    Optional<String> deleteNote(String id);
    Optional<NoteResponse> insertNote(Note note);
    Optional<NoteResponse> updateNote(String id,Note note);
}
