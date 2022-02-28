/*
 * Copyright 2017-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.lettuce.core.cluster.api.async;

import java.util.List;
import java.util.Set;

import io.lettuce.core.ScanArgs;
import io.lettuce.core.ScanCursor;
import io.lettuce.core.StreamScanCursor;
import io.lettuce.core.ValueScanCursor;
import io.lettuce.core.output.ValueStreamingChannel;

/**
 * Asynchronous executed commands on a node selection for Sets.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mark Paluch
 * @since 4.0
 * @generated by io.lettuce.apigenerator.CreateAsyncNodeSelectionClusterApi
 */
public interface NodeSelectionSetAsyncCommands<K, V> {

    /**
     * Add one or more members to a set.
     *
     * @param key the key.
     * @param members the member type: value.
     * @return Long integer-reply the number of elements that were added to the set, not including all the elements already
     *         present into the set.
     */
    AsyncExecutions<Long> sadd(K key, V... members);

    /**
     * Get the number of members in a set.
     *
     * @param key the key.
     * @return Long integer-reply the cardinality (number of elements) of the set, or {@code false} if {@code key} does not
     *         exist.
     */
    AsyncExecutions<Long> scard(K key);

    /**
     * Subtract multiple sets.
     *
     * @param keys the key.
     * @return Set&lt;V&gt; array-reply list with members of the resulting set.
     */
    AsyncExecutions<Set<V>> sdiff(K... keys);

    /**
     * Subtract multiple sets.
     *
     * @param channel the channel.
     * @param keys the keys.
     * @return Long count of members of the resulting set.
     */
    AsyncExecutions<Long> sdiff(ValueStreamingChannel<V> channel, K... keys);

    /**
     * Subtract multiple sets and store the resulting set in a key.
     *
     * @param destination the destination type: key.
     * @param keys the key.
     * @return Long integer-reply the number of elements in the resulting set.
     */
    AsyncExecutions<Long> sdiffstore(K destination, K... keys);

    /**
     * Intersect multiple sets.
     *
     * @param keys the key.
     * @return Set&lt;V&gt; array-reply list with members of the resulting set.
     */
    AsyncExecutions<Set<V>> sinter(K... keys);

    /**
     * Intersect multiple sets.
     *
     * @param channel the channel.
     * @param keys the keys.
     * @return Long count of members of the resulting set.
     */
    AsyncExecutions<Long> sinter(ValueStreamingChannel<V> channel, K... keys);

    /**
     * This command works exactly like {@link #sinter(java.lang.Object[])} but instead of returning the result set, it returns
     * just the cardinality of the result.
     *
     * @param keys the keys.
     * @return The cardinality of the set which would result from the intersection of all the given sets.
     * @since 6.2
     */
    AsyncExecutions<Long> sintercard(K... keys);

    /**
     * This command works exactly like {@link #sinter(java.lang.Object[])} but instead of returning the result set, it returns
     * just the cardinality of the result.
     *
     * @param limit If the intersection cardinality reaches limit partway through the computation, the algorithm will exit and
     *        yield limit as the cardinality.
     * @param keys the keys.
     * @return The cardinality of the set which would result from the intersection of all the given sets.
     * @since 6.2
     */
    AsyncExecutions<Long> sintercard(long limit, K... keys);

    /**
     * Intersect multiple sets and store the resulting set in a key.
     *
     * @param destination the destination type: key.
     * @param keys the key.
     * @return Long integer-reply the number of elements in the resulting set.
     */
    AsyncExecutions<Long> sinterstore(K destination, K... keys);

    /**
     * Determine if a given value is a member of a set.
     *
     * @param key the key.
     * @param member the member type: value.
     * @return Boolean integer-reply specifically:
     *
     *         {@code true} if the element is a member of the set. {@code false} if the element is not a member of the set, or
     *         if {@code key} does not exist.
     */
    AsyncExecutions<Boolean> sismember(K key, V member);

    /**
     * Get all the members in a set.
     *
     * @param key the key.
     * @return Set&lt;V&gt; array-reply all elements of the set.
     */
    AsyncExecutions<Set<V>> smembers(K key);

    /**
     * Get all the members in a set.
     *
     * @param channel the channel.
     * @param key the keys.
     * @return Long count of members of the resulting set.
     */
    AsyncExecutions<Long> smembers(ValueStreamingChannel<V> channel, K key);

    /**
     * Returns whether each member is a member of the set stored at key.
     *
     * @param key the key.
     * @param members the member type: value.
     * @return List&lt;Boolean&gt; array-reply list representing the membership of the given elements, in the same order as they
     *         are requested.
     * @since 6.1
     */
    AsyncExecutions<List<Boolean>> smismember(K key, V... members);

    /**
     * Move a member from one set to another.
     *
     * @param source the source key.
     * @param destination the destination type: key.
     * @param member the member type: value.
     * @return Boolean integer-reply specifically:
     *
     *         {@code true} if the element is moved. {@code false} if the element is not a member of {@code source} and no
     *         operation was performed.
     */
    AsyncExecutions<Boolean> smove(K source, K destination, V member);

    /**
     * Remove and return a random member from a set.
     *
     * @param key the key.
     * @return V bulk-string-reply the removed element, or {@code null} when {@code key} does not exist.
     */
    AsyncExecutions<V> spop(K key);

    /**
     * Remove and return one or multiple random members from a set.
     *
     * @param key the key.
     * @param count number of members to pop.
     * @return V bulk-string-reply the removed element, or {@code null} when {@code key} does not exist.
     */
    AsyncExecutions<Set<V>> spop(K key, long count);

    /**
     * Get one random member from a set.
     *
     * @param key the key.
     * @return V bulk-string-reply without the additional {@code count} argument the command returns a Bulk Reply with the
     *         randomly selected element, or {@code null} when {@code key} does not exist.
     */
    AsyncExecutions<V> srandmember(K key);

    /**
     * Get one or multiple random members from a set.
     *
     * @param key the key.
     * @param count the count type: long.
     * @return Set&lt;V&gt; bulk-string-reply without the additional {@code count} argument the command returns a Bulk Reply
     *         with the randomly selected element, or {@code null} when {@code key} does not exist.
     */
    AsyncExecutions<List<V>> srandmember(K key, long count);

    /**
     * Get one or multiple random members from a set.
     *
     * @param channel streaming channel that receives a call for every value.
     * @param key the key.
     * @param count the count.
     * @return Long count of members of the resulting set.
     */
    AsyncExecutions<Long> srandmember(ValueStreamingChannel<V> channel, K key, long count);

    /**
     * Remove one or more members from a set.
     *
     * @param key the key.
     * @param members the member type: value.
     * @return Long integer-reply the number of members that were removed from the set, not including non existing members.
     */
    AsyncExecutions<Long> srem(K key, V... members);

    /**
     * Add multiple sets.
     *
     * @param keys the key.
     * @return Set&lt;V&gt; array-reply list with members of the resulting set.
     */
    AsyncExecutions<Set<V>> sunion(K... keys);

    /**
     * Add multiple sets.
     *
     * @param channel streaming channel that receives a call for every value.
     * @param keys the keys.
     * @return Long count of members of the resulting set.
     */
    AsyncExecutions<Long> sunion(ValueStreamingChannel<V> channel, K... keys);

    /**
     * Add multiple sets and store the resulting set in a key.
     *
     * @param destination the destination type: key.
     * @param keys the key.
     * @return Long integer-reply the number of elements in the resulting set.
     */
    AsyncExecutions<Long> sunionstore(K destination, K... keys);

    /**
     * Incrementally iterate Set elements.
     *
     * @param key the key.
     * @return ValueScanCursor&lt;V&gt; scan cursor.
     */
    AsyncExecutions<ValueScanCursor<V>> sscan(K key);

    /**
     * Incrementally iterate Set elements.
     *
     * @param key the key.
     * @param scanArgs scan arguments.
     * @return ValueScanCursor&lt;V&gt; scan cursor.
     */
    AsyncExecutions<ValueScanCursor<V>> sscan(K key, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     *
     * @param key the key.
     * @param scanCursor cursor to resume from a previous scan, must not be {@code null}.
     * @param scanArgs scan arguments.
     * @return ValueScanCursor&lt;V&gt; scan cursor.
     */
    AsyncExecutions<ValueScanCursor<V>> sscan(K key, ScanCursor scanCursor, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     *
     * @param key the key.
     * @param scanCursor cursor to resume from a previous scan, must not be {@code null}.
     * @return ValueScanCursor&lt;V&gt; scan cursor.
     */
    AsyncExecutions<ValueScanCursor<V>> sscan(K key, ScanCursor scanCursor);

    /**
     * Incrementally iterate Set elements.
     *
     * @param channel streaming channel that receives a call for every value.
     * @param key the key.
     * @return StreamScanCursor scan cursor.
     */
    AsyncExecutions<StreamScanCursor> sscan(ValueStreamingChannel<V> channel, K key);

    /**
     * Incrementally iterate Set elements.
     *
     * @param channel streaming channel that receives a call for every value.
     * @param key the key.
     * @param scanArgs scan arguments.
     * @return StreamScanCursor scan cursor.
     */
    AsyncExecutions<StreamScanCursor> sscan(ValueStreamingChannel<V> channel, K key, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     *
     * @param channel streaming channel that receives a call for every value.
     * @param key the key.
     * @param scanCursor cursor to resume from a previous scan, must not be {@code null}.
     * @param scanArgs scan arguments.
     * @return StreamScanCursor scan cursor.
     */
    AsyncExecutions<StreamScanCursor> sscan(ValueStreamingChannel<V> channel, K key, ScanCursor scanCursor, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     *
     * @param channel streaming channel that receives a call for every value.
     * @param key the key.
     * @param scanCursor cursor to resume from a previous scan, must not be {@code null}.
     * @return StreamScanCursor scan cursor.
     */
    AsyncExecutions<StreamScanCursor> sscan(ValueStreamingChannel<V> channel, K key, ScanCursor scanCursor);
}
