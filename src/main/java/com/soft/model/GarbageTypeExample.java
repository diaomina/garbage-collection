package com.soft.model;

import java.util.ArrayList;
import java.util.List;

public class GarbageTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GarbageTypeExample() {
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

        public Criteria andGarbagetypenameIsNull() {
            addCriterion("garbageTypeName is null");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameIsNotNull() {
            addCriterion("garbageTypeName is not null");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameEqualTo(String value) {
            addCriterion("garbageTypeName =", value, "garbagetypename");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameNotEqualTo(String value) {
            addCriterion("garbageTypeName <>", value, "garbagetypename");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameGreaterThan(String value) {
            addCriterion("garbageTypeName >", value, "garbagetypename");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameGreaterThanOrEqualTo(String value) {
            addCriterion("garbageTypeName >=", value, "garbagetypename");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameLessThan(String value) {
            addCriterion("garbageTypeName <", value, "garbagetypename");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameLessThanOrEqualTo(String value) {
            addCriterion("garbageTypeName <=", value, "garbagetypename");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameLike(String value) {
            addCriterion("garbageTypeName like", value, "garbagetypename");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameNotLike(String value) {
            addCriterion("garbageTypeName not like", value, "garbagetypename");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameIn(List<String> values) {
            addCriterion("garbageTypeName in", values, "garbagetypename");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameNotIn(List<String> values) {
            addCriterion("garbageTypeName not in", values, "garbagetypename");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameBetween(String value1, String value2) {
            addCriterion("garbageTypeName between", value1, value2, "garbagetypename");
            return (Criteria) this;
        }

        public Criteria andGarbagetypenameNotBetween(String value1, String value2) {
            addCriterion("garbageTypeName not between", value1, value2, "garbagetypename");
            return (Criteria) this;
        }

        public Criteria andGarbagetipIsNull() {
            addCriterion("garbageTip is null");
            return (Criteria) this;
        }

        public Criteria andGarbagetipIsNotNull() {
            addCriterion("garbageTip is not null");
            return (Criteria) this;
        }

        public Criteria andGarbagetipEqualTo(String value) {
            addCriterion("garbageTip =", value, "garbagetip");
            return (Criteria) this;
        }

        public Criteria andGarbagetipNotEqualTo(String value) {
            addCriterion("garbageTip <>", value, "garbagetip");
            return (Criteria) this;
        }

        public Criteria andGarbagetipGreaterThan(String value) {
            addCriterion("garbageTip >", value, "garbagetip");
            return (Criteria) this;
        }

        public Criteria andGarbagetipGreaterThanOrEqualTo(String value) {
            addCriterion("garbageTip >=", value, "garbagetip");
            return (Criteria) this;
        }

        public Criteria andGarbagetipLessThan(String value) {
            addCriterion("garbageTip <", value, "garbagetip");
            return (Criteria) this;
        }

        public Criteria andGarbagetipLessThanOrEqualTo(String value) {
            addCriterion("garbageTip <=", value, "garbagetip");
            return (Criteria) this;
        }

        public Criteria andGarbagetipLike(String value) {
            addCriterion("garbageTip like", value, "garbagetip");
            return (Criteria) this;
        }

        public Criteria andGarbagetipNotLike(String value) {
            addCriterion("garbageTip not like", value, "garbagetip");
            return (Criteria) this;
        }

        public Criteria andGarbagetipIn(List<String> values) {
            addCriterion("garbageTip in", values, "garbagetip");
            return (Criteria) this;
        }

        public Criteria andGarbagetipNotIn(List<String> values) {
            addCriterion("garbageTip not in", values, "garbagetip");
            return (Criteria) this;
        }

        public Criteria andGarbagetipBetween(String value1, String value2) {
            addCriterion("garbageTip between", value1, value2, "garbagetip");
            return (Criteria) this;
        }

        public Criteria andGarbagetipNotBetween(String value1, String value2) {
            addCriterion("garbageTip not between", value1, value2, "garbagetip");
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