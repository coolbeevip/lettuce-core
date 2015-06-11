package com.lambdaworks.redis;

import java.util.Set;

import com.lambdaworks.redis.api.sync.RedisSetCommands;
import com.lambdaworks.redis.output.ValueStreamingChannel;

/**
 * Synchronous executed commands for Sets.
 * 
 * @param <K> Key type.
 * @param <V> Value type.
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 3.0
 * @deprecated Use {@link RedisSetCommands}
 */
@Deprecated
public interface RedisSetsConnection<K, V> {
    /**
     * Add one or more members to a set.
     * 
     * @param key the key
     * @param members the member type: value
     * @return Long integer-reply the number of elements that were added to the set, not including all the elements already
     *         present into the set.
     */
    Long sadd(K key, V... members);

    /**
     * Get the number of members in a set.
     * 
     * @param key the key
     * @return Long integer-reply the cardinality (number of elements) of the set, or {@literal false} if {@code key} does not
     *         exist.
     */
    Long scard(K key);

    /**
     * Subtract multiple sets.
     * 
     * @param keys the key
     * @return Set&lt;V&gt; array-reply list with members of the resulting set.
     */
    Set<V> sdiff(K... keys);

    /**
     * Subtract multiple sets.
     * 
     * @param channel the channel
     * @param keys the keys
     * @return Long count of members of the resulting set.
     */
    Long sdiff(ValueStreamingChannel<V> channel, K... keys);

    /**
     * Subtract multiple sets and store the resulting set in a key.
     * 
     * @param destination the destination type: key
     * @param keys the key
     * @return Long integer-reply the number of elements in the resulting set.
     */
    Long sdiffstore(K destination, K... keys);

    /**
     * Intersect multiple sets.
     * 
     * @param keys the key
     * @return Set&lt;V&gt; array-reply list with members of the resulting set.
     */
    Set<V> sinter(K... keys);

    /**
     * Intersect multiple sets.
     * 
     * @param channel the channel
     * @param keys the keys
     * @return Long count of members of the resulting set.
     */
    Long sinter(ValueStreamingChannel<V> channel, K... keys);

    /**
     * Intersect multiple sets and store the resulting set in a key.
     * 
     * @param destination the destination type: key
     * @param keys the key
     * @return Long integer-reply the number of elements in the resulting set.
     */
    Long sinterstore(K destination, K... keys);

    /**
     * Determine if a given value is a member of a set.
     * 
     * @param key the key
     * @param member the member type: value
     * @return Boolean integer-reply specifically:
     * 
     *         {@literal true} if the element is a member of the set. {@literal false} if the element is not a member of the
     *         set, or if {@code key} does not exist.
     */
    Boolean sismember(K key, V member);

    /**
     * Move a member from one set to another.
     * 
     * @param source the source type: key
     * @param destination the destination type: key
     * @param member the member type: value
     * @return Boolean integer-reply specifically:
     * 
     *         {@literal true} if the element is moved. {@literal false} if the element is not a member of {@code source} and no
     *         operation was performed.
     */
    Boolean smove(K source, K destination, V member);

    /**
     * Get all the members in a set.
     * 
     * @param key the key
     * @return Set&lt;V&gt; array-reply all elements of the set.
     */
    Set<V> smembers(K key);

    /**
     * Get all the members in a set.
     * 
     * @param channel the channel
     * @param key the keys
     * @return Long count of members of the resulting set.
     */
    Long smembers(ValueStreamingChannel<V> channel, K key);

    /**
     * Remove and return a random member from a set.
     * 
     * @param key the key
     * @return V bulk-string-reply the removed element, or {@literal null} when {@code key} does not exist.
     */
    V spop(K key);

    /**
     * Get one or multiple random members from a set.
     * 
     * @param key the key
     * 
     * @return V bulk-string-reply without the additional {@code count} argument the command returns a Bulk Reply with the
     *         randomly selected element, or {@literal null} when {@code key} does not exist.
     */
    V srandmember(K key);

    /**
     * Get one or multiple random members from a set.
     * 
     * @param key the key
     * @param count the count type: long
     * @return Set&lt;V&gt; bulk-string-reply without the additional {@code count} argument the command returns a Bulk Reply
     *         with the randomly selected element, or {@literal null} when {@code key} does not exist.
     */
    Set<V> srandmember(K key, long count);

    /**
     * Get one or multiple random members from a set.
     * 
     * @param channel streaming channel that receives a call for every value
     * @param key the key
     * @param count the count
     * @return Long count of members of the resulting set.
     */
    Long srandmember(ValueStreamingChannel<V> channel, K key, long count);

    /**
     * Remove one or more members from a set.
     * 
     * @param key the key
     * @param members the member type: value
     * @return Long integer-reply the number of members that were removed from the set, not including non existing members.
     */
    Long srem(K key, V... members);

    /**
     * Add multiple sets.
     * 
     * @param keys the key
     * @return Set&lt;V&gt; array-reply list with members of the resulting set.
     */
    Set<V> sunion(K... keys);

    /**
     * Add multiple sets.
     * 
     * @param channel streaming channel that receives a call for every value
     * @param keys the keys
     * @return Long count of members of the resulting set.
     */
    Long sunion(ValueStreamingChannel<V> channel, K... keys);

    /**
     * Add multiple sets and store the resulting set in a key.
     * 
     * @param destination the destination type: key
     * @param keys the key
     * @return Long integer-reply the number of elements in the resulting set.
     */
    Long sunionstore(K destination, K... keys);

    /**
     * Incrementally iterate Set elements.
     * 
     * @param key the key
     * @return ValueScanCursor&lt;V&gt; scan cursor.
     */
    ValueScanCursor<V> sscan(K key);

    /**
     * Incrementally iterate Set elements.
     * 
     * @param key the key
     * @param scanArgs scan arguments
     * @return ValueScanCursor&lt;V&gt; scan cursor.
     */
    ValueScanCursor<V> sscan(K key, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     * 
     * @param key the key
     * @param scanCursor cursor to resume from a previous scan
     * @param scanArgs scan arguments
     * @return ValueScanCursor&lt;V&gt; scan cursor.
     */
    ValueScanCursor<V> sscan(K key, ScanCursor scanCursor, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     * 
     * @param key the key
     * @param scanCursor cursor to resume from a previous scan
     * @return ValueScanCursor&lt;V&gt; scan cursor.
     */
    ValueScanCursor<V> sscan(K key, ScanCursor scanCursor);

    /**
     * Incrementally iterate Set elements.
     * 
     * @param channel streaming channel that receives a call for every value
     * @param key the key
     * @return StreamScanCursor scan cursor.
     */
    StreamScanCursor sscan(ValueStreamingChannel<V> channel, K key);

    /**
     * Incrementally iterate Set elements.
     * 
     * @param channel streaming channel that receives a call for every value
     * @param key the key
     * @param scanArgs scan arguments
     * @return StreamScanCursor scan cursor.
     */
    StreamScanCursor sscan(ValueStreamingChannel<V> channel, K key, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     * 
     * @param channel streaming channel that receives a call for every value
     * @param key the key
     * @param scanCursor cursor to resume from a previous scan
     * @param scanArgs scan arguments
     * @return StreamScanCursor scan cursor.
     */
    StreamScanCursor sscan(ValueStreamingChannel<V> channel, K key, ScanCursor scanCursor, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     * 
     * @param channel streaming channel that receives a call for every value
     * @param key the key
     * @param scanCursor cursor to resume from a previous scan
     * @return StreamScanCursor scan cursor.
     */
    StreamScanCursor sscan(ValueStreamingChannel<V> channel, K key, ScanCursor scanCursor);
}
