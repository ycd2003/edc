package com.xyyh.meta.service.impl;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;
import com.xyyh.meta.converter.TableConverter;
import com.xyyh.meta.dto.TableDto;
import com.xyyh.meta.entity.QTable;
import com.xyyh.meta.entity.Table;
import com.xyyh.meta.repository.TableRepository;
import com.xyyh.meta.service.TableService;

@Service
public class TableServiceImpl implements TableService {

	@Autowired
	private TableRepository tableRepository;

	@Autowired
	private TableConverter tableConverter;

	private final QTable qTable = QTable.table;

	@Override
	public Optional<Table> findById(Long id) {
		return tableRepository.findById(id);
	}

	@Override
	@Transactional
	public Table update(Long id, TableDto table) {
		Table result = tableRepository.getOne(id);
		tableConverter.copyProperties(result, table);
		return tableRepository.save(result);
	}

	@Override
	public Page<Table> find(String keywords, Pageable pageable) {
		BooleanBuilder condition = new BooleanBuilder();
		if (StringUtils.isNotBlank(keywords)) {
			condition.and(qTable.name.containsIgnoreCase(keywords));
		}
		return tableRepository.findAll(condition, pageable);
	}

}
