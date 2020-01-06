package com.briup.shopping.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingcarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShoppingcarExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Integer value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Integer value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Integer value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Integer value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Integer> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Integer> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIsNull() {
            addCriterion("orderTime is null");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIsNotNull() {
            addCriterion("orderTime is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertimeEqualTo(Date value) {
            addCriterion("orderTime =", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotEqualTo(Date value) {
            addCriterion("orderTime <>", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeGreaterThan(Date value) {
            addCriterion("orderTime >", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeGreaterThanOrEqualTo(Date value) {
            addCriterion("orderTime >=", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLessThan(Date value) {
            addCriterion("orderTime <", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeLessThanOrEqualTo(Date value) {
            addCriterion("orderTime <=", value, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeIn(List<Date> values) {
            addCriterion("orderTime in", values, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotIn(List<Date> values) {
            addCriterion("orderTime not in", values, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeBetween(Date value1, Date value2) {
            addCriterion("orderTime between", value1, value2, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdertimeNotBetween(Date value1, Date value2) {
            addCriterion("orderTime not between", value1, value2, "ordertime");
            return (Criteria) this;
        }

        public Criteria andOrdercountIsNull() {
            addCriterion("orderCount is null");
            return (Criteria) this;
        }

        public Criteria andOrdercountIsNotNull() {
            addCriterion("orderCount is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercountEqualTo(Short value) {
            addCriterion("orderCount =", value, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountNotEqualTo(Short value) {
            addCriterion("orderCount <>", value, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountGreaterThan(Short value) {
            addCriterion("orderCount >", value, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountGreaterThanOrEqualTo(Short value) {
            addCriterion("orderCount >=", value, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountLessThan(Short value) {
            addCriterion("orderCount <", value, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountLessThanOrEqualTo(Short value) {
            addCriterion("orderCount <=", value, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountIn(List<Short> values) {
            addCriterion("orderCount in", values, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountNotIn(List<Short> values) {
            addCriterion("orderCount not in", values, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountBetween(Short value1, Short value2) {
            addCriterion("orderCount between", value1, value2, "ordercount");
            return (Criteria) this;
        }

        public Criteria andOrdercountNotBetween(Short value1, Short value2) {
            addCriterion("orderCount not between", value1, value2, "ordercount");
            return (Criteria) this;
        }

        public Criteria andSalepriceIsNull() {
            addCriterion("salePrice is null");
            return (Criteria) this;
        }

        public Criteria andSalepriceIsNotNull() {
            addCriterion("salePrice is not null");
            return (Criteria) this;
        }

        public Criteria andSalepriceEqualTo(Float value) {
            addCriterion("salePrice =", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceNotEqualTo(Float value) {
            addCriterion("salePrice <>", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceGreaterThan(Float value) {
            addCriterion("salePrice >", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceGreaterThanOrEqualTo(Float value) {
            addCriterion("salePrice >=", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceLessThan(Float value) {
            addCriterion("salePrice <", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceLessThanOrEqualTo(Float value) {
            addCriterion("salePrice <=", value, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceIn(List<Float> values) {
            addCriterion("salePrice in", values, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceNotIn(List<Float> values) {
            addCriterion("salePrice not in", values, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceBetween(Float value1, Float value2) {
            addCriterion("salePrice between", value1, value2, "saleprice");
            return (Criteria) this;
        }

        public Criteria andSalepriceNotBetween(Float value1, Float value2) {
            addCriterion("salePrice not between", value1, value2, "saleprice");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}