package br.com.haraujo.service;

import br.com.haraujo.persistence.dao.BoardColumnDao;
import br.com.haraujo.persistence.dao.BoardDao;
import br.com.haraujo.persistence.entity.BoardEntity;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@AllArgsConstructor
public class BoardQueryService {

    private final Connection connection;

    public Optional<BoardEntity> findById(final Long id) throws SQLException {
        var dao = new BoardDao(connection);
        var boardColumnDao = new BoardColumnDao(connection);
        var optional = dao.findById(id);
        if (optional.isPresent()) {
            var entity = optional.get();
            entity.setBoardColumns(boardColumnDao.findByBoardId(entity.getId()));
            return Optional.of(entity);
        }
        return Optional.empty();
    }
}
