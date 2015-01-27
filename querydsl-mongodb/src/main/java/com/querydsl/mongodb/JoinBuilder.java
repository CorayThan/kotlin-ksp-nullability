/*
 * Copyright 2012, Mysema Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.querydsl.mongodb;

import com.querydsl.core.JoinType;
import com.querydsl.core.support.QueryMixin;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;

/**
 * JoinBuilder is a builder for join constraints
 *
 * @author tiwe
 *
 * @param <Q>
 * @param <K>
 * @param <T>
 */
public class JoinBuilder<Q extends MongodbQuery<Q,K>, K, T> {

    private final QueryMixin<Q> queryMixin;

    private final Path<?> ref;

    private final Path<T> target;

    public JoinBuilder(QueryMixin<Q> queryMixin, Path<?> ref, Path<T> target) {
        this.queryMixin = queryMixin;
        this.ref = ref;
        this.target = target;
    }

    public Q on(Predicate... conditions) {
        queryMixin.addJoin(JoinType.JOIN, ExpressionUtils.as((Path)ref, target));
        queryMixin.on(conditions);
        return queryMixin.getSelf();
    }

}
