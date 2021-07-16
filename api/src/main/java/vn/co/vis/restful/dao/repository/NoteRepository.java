package vn.co.vis.restful.dao.repository;

import vn.co.vis.restful.dao.entity.Note;
import vn.co.vis.restful.dto.response.NoteResponse;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {
    Optional<NoteResponse> getNote(String id, String userId);
    Optional<List<Note>> getNotesByFolderId(String folderId, String userId);
    Optional<List<Note>> getNotesByContentId(String contentId, String userId);
    String deleteNote(String id);
    Optional<NoteResponse> insertNote(Note note);
    Optional<NoteResponse> updateNote(String id,Note note);
}
