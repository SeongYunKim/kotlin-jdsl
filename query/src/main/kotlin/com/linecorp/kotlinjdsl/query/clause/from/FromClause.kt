package com.linecorp.kotlinjdsl.query.clause.from

import com.linecorp.kotlinjdsl.query.spec.Froms
import com.linecorp.kotlinjdsl.query.spec.expression.EntitySpec
import javax.persistence.criteria.AbstractQuery
import javax.persistence.criteria.CriteriaDelete
import javax.persistence.criteria.CriteriaUpdate

/**
 * Internal Only
 * Don't use this directly because it's an <string>INTERNAL</strong>.
 * It does not support backward compatibility.
 */
data class FromClause(
    val entity: EntitySpec<*>,
) {
    fun join(joinClause: JoinClause, query: AbstractQuery<*>): Froms {
        return Joiner(entity, joinClause.joins, query).joinAll()
    }

    fun associate(joinClause: SimpleAssociatedJoinClause, query: CriteriaUpdate<in Any>, targetEntity: Class<*>): Froms {
        return SimpleAssociator(entity, joinClause.joins, query.from(targetEntity)).associateAll()
    }

    fun associate(joinClause: SimpleAssociatedJoinClause, query: CriteriaDelete<in Any>, targetEntity: Class<*>): Froms {
        return SimpleAssociator(entity, joinClause.joins, query.from(targetEntity)).associateAll()
    }
}
