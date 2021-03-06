package com.xyyh.edc.meta.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.xyyh.edc.meta.api.ColumnFormAttributes;
import com.xyyh.edc.meta.api.FixedValueTypes;
import com.xyyh.edc.meta.api.InputControls;
import com.xyyh.edc.meta.api.ValueSourceTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class ColumnFormAttributesDto implements Serializable, ColumnFormAttributes {
	private static final long serialVersionUID = 646150343127467359L;

	/**
	 * 字段显示的标题
	 */
	private String title;

	/**
	 * 允许输入的最大值
	 */
	private BigDecimal min;

	/**
	 * 允许输入的最小值
	 */
	private BigDecimal max;

	/**
	 * 输入框控件类型
	 */
	private InputControls inputControl;

	/**
	 * 真值标签
	 */
	private String trueLabel;

	/**
	 * 假值标签
	 */
	private String falseLabel;

	/**
	 * 值域的来源
	 */
	private ValueSourceTypes valueSourceType;

	/**
	 * 固定值域的值类型
	 */
	public FixedValueTypes fixedValueType;

	/**
	 * 固定值域的值
	 */
	private String fixedValue;

	/**
	 * 额外的选项，使用json包装
	 */
	private String options;

}
