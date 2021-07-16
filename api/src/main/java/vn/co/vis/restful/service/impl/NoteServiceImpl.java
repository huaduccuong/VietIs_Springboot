package vn.co.vis.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.Note;
import vn.co.vis.restful.dao.repository.FolderRepository;
import vn.co.vis.restful.dao.repository.NoteRepository;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.dto.response.NoteResponse;
import vn.co.vis.restful.exception.ResourceNotFoundException;
import vn.co.vis.restful.service.AbstractService;
import vn.co.vis.restful.service.NoteService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl extends AbstractService implements NoteService {
    @Autowired
    NoteRepository noteRepository;
    @Override
    public Optional<NoteResponse> getNote(String id, String userId) {
        Optional<NoteResponse>  noteResponse = noteRepository.getNote(id,userId);
        return noteResponse ;
    }

    @Override
    public Optional<List<NoteResponse>> getNotesByFolderId(String folderId, String userId) {
        List<Note> notes = noteRepository.getNotesByFolderId(folderId,userId).orElseThrow(() -> {
            throw new ResourceNotFoundException();
        });
        return Optional.of(notes.stream()
                .map(note -> new NoteResponse(note.getId(),
                        note.getNote(),note.getDate(),
                        note.getUserId(),note.getFolderId(),note.getContentId()))
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<NoteResponse>> getNotesByContentId(String contentId, String userId) {
        List<Note> notes = noteRepository.getNotesByFolderId(contentId,userId).orElseThrow(() -> {
            throw new ResourceNotFoundException();
        });
        return Optional.of(notes.stream()
                .map(note -> new NoteResponse(note.getId(),
                        note.getNote(),note.getDate(),
                        note.getUserId(),note.getFolderId(),note.getContentId()))
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<String> deleteNote(String id) {
        String  noteResponse = noteRepository.deleteNote(id);
        return Optional.of(noteResponse) ;
    }

    @Override
    public Optional<NoteResponse> insertNote(Note note) {
        Optional<NoteResponse>  noteResponse = noteRepository.insertNote(note);
        return noteResponse ;
    }

    @Override
    public Optional<NoteResponse> updateNote(String id, Note note) {
        Optional<NoteResponse>  noteResponse = noteRepository.updateNote(id,note);
        return noteResponse ;
    }
}
