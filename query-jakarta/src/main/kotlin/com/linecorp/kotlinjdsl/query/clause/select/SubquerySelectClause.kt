package com.linecorp.kotlinjdsl.query.clause.select

import com.linecorp.kotlinjdsl.query.spec.Froms
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Subquery

/**
 * Internal Only
 * Don't use this directly because it's an **INTERNAL**.
 * It does not support backward compatibility.
 */
interface SubquerySelectClause<T> {
    val returnType: Class<T>

    fun apply(froms: Froms, query: Subquery<T>, criteriaBuilder: CriteriaBuilder)
}
