package br.com.haraujo.service;

import br.com.haraujo.persistence.dao.BoardColumnDao;
import br.com.haraujo.persistence.dao.BoardDao;
import br.com.haraujo.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;

@AllArgsConstructor
public class BoardService {

    private final Connection connection;

    public BoardEntity insert(final BoardEntity entity) throws SQLException {
        var dao = new BoardDao(connection);
        var boardColumnDao = new BoardColumnDao(connection);
        try{
            dao.insert(entity);
           var columns = entity.getBoardColumns().stream().map(c -> {
                c.setBoard(entity);
                return  c;
            }).toList();
           for (var column : columns){
               boardColumnDao.insert(column);
           }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
        return entity;
    }

    public boolean delete(final Long id) throws SQLException {
        var dao = new BoardDao(connection);
        try {
           if (!dao.exists(id)) {
                return false;
           }
            dao.delete(id);
            connection.commit();
            return true;
        }catch (SQLException e) {
            connection.rollback();
            throw  e;
        }
    }
}
