package br.com.haraujo.persistence.dao;


import br.com.haraujo.persistence.entity.BoardColumnEntity;
import br.com.haraujo.persistence.entity.BoardColumnKindEnum;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static br.com.haraujo.persistence.entity.BoardColumnKindEnum.findByName;

@RequiredArgsConstructor
public class BoardColumnDao {

    private final Connection connection;

    public BoardColumnEntity insert(final BoardColumnEntity entity) throws SQLException {
        var sql = "INSERT INTO BOARDS_COLUMNS (name, `order`, kind, board_id) VALUE (?, ?, ?, ?";
        try(var statement = connection.prepareStatement(sql)){
            var i =1;
            statement.setString(i ++, entity.getName());
            statement.setInt(i ++, entity.getOrder());
            statement.setString(i ++, entity.getKind().name());
            statement.setLong(i, entity.getBoard().getId());
            statement.executeUpdate();
        }
        return  entity;
    }

    public List<BoardColumnEntity> findByBoardId(Long id) throws SQLException {
        List<BoardColumnEntity> entities = new ArrayList<>();
        var sql = "SELECT id, name, `oeder` FROM BOARDS_COLUMNS WHERE board_id = ? ORDER BY `order`";
        try(var stattement = connection.prepareStatement(sql)){
            stattement.setLong(1, id);
            stattement.executeQuery();
            var resultset = stattement.getResultSet();
            while (resultset.next()){
                var entity = new BoardColumnEntity();
                entity.setId(resultset.getLong("id"));
                entity.setName(resultset.getString("name"));
                entity.setOrder(resultset.getInt("order"));
                entity.setKind(findByName(resultset.getString("kind")));
                entities.add(entity);
            }
        }
        return entities;
    }
}
