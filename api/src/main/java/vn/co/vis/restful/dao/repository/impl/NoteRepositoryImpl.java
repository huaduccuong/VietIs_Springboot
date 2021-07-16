package vn.co.vis.restful.dao.repository.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import vn.co.vis.restful.dao.entity.Folder;
import vn.co.vis.restful.dao.entity.Note;
import vn.co.vis.restful.dao.repository.AbstractRepository;
import vn.co.vis.restful.dao.repository.NoteRepository;
import vn.co.vis.restful.dto.response.FolderResponse;
import vn.co.vis.restful.dto.response.NoteResponse;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
@Repository
public class NoteRepositoryImpl extends AbstractRepository implements NoteRepository {
    @Override
    public Optional<NoteResponse> getNote(String id, String userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(attributeNamesForSelect(Note.class));
        sql.append(" FROM ").append(getSimpleNameTable(Note.class));
        sql.append(" WHERE id = ? and user_id = ?");
        NoteResponse noteResponse = jdbcTemplate.queryForObject(sql.toString(), new String[]{id,userId}, new BeanPropertyRowMapper<>(NoteResponse.class));
        return Optional.ofNullable(noteResponse);
    }

    @Override
    public Optional<List<Note>> getNotesByFolderId(String folderId, String userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(attributeNamesForSelect(Note.class));
        sql.append(" FROM ").append(getSimpleNameTable(Note.class));
        sql.append(" WHERE folder_id = ? and user_id = ?");
        List<Note> notes = jdbcTemplate.query(sql.toString(), new String[]{folderId, userId}, new BeanPropertyRowMapper<>(Note.class));
        return Optional.ofNullable(notes);
    }

    @Override
    public Optional<List<Note>> getNotesByContentId(String contentId, String userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ").append(attributeNamesForSelect(Note.class));
        sql.append(" FROM ").append(getSimpleNameTable(Note.class));
        sql.append(" WHERE folder_id = ? and user_id = ?");
        List<Note> notes = jdbcTemplate.query(sql.toString(), new String[]{contentId, userId}, new BeanPropertyRowMapper<>(Note.class));
        return Optional.ofNullable(notes);
    }

    @Override
    public String deleteNote(String id) {
        String sql = "delete from "+getSimpleNameTable(Note.class)+" where id = ?";
        Object[] noteId = new Object[] {id};
        jdbcTemplate.update(sql,noteId);
        return  "delete success";
    }

    @Override
    public Optional<NoteResponse> insertNote(Note note) {
        String sql2 = "insert into "+getSimpleNameTable(Note.class)+"(note,date,user_id,content_id,folder_id)"
                +" values (?,?,?,?,?)";
        jdbcTemplate.update(sql2,note.getNote(),note.getDate(),note.getUserId(),note.getContentId(),note.getFolderId());
        NoteResponse noteResponse =  new NoteResponse();
        noteResponse.setNote(note.getNote());
        noteResponse.setDate(note.getDate());
        noteResponse.setContentId(note.getContentId());
        noteResponse.setFolderId(note.getFolderId());
        noteResponse.setUserId(note.getUserId());
        return  Optional.ofNullable(noteResponse);
    }

    @Override
    public Optional<NoteResponse> updateNote(String id, Note note) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(note.getDate());
        String sql = "update " + getSimpleNameTable(Note.class) + " set note = ?, date = ? where id = ?";
        jdbcTemplate.update(sql,note.getNote(),date,id);
        NoteResponse noteResponse =  new NoteResponse();
        noteResponse.setNote(note.getNote());
        noteResponse.setDate(note.getDate());
        return  Optional.ofNullable(noteResponse);
    }
}
