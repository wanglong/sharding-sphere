/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.dbtest.common;

import com.google.common.base.Splitter;
import io.shardingsphere.dbtest.cases.dataset.init.DataSetMetadata;
import lombok.Getter;

import java.text.ParseException;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Group of SQL value.
 *
 * @author zhangliang
 */
@Getter
public final class SQLValueGroup {
    
    private final Collection<SQLValue> sqlValues;
    
    public SQLValueGroup(final DataSetMetadata dataSetMetadata, final String values) throws ParseException {
        sqlValues = new LinkedList<>();
        int count = 0;
        for (String each : Splitter.on(',').trimResults().splitToList(values)) {
            sqlValues.add(new SQLValue(each, dataSetMetadata.getColumnMetadataList().get(count).getType(), count + 1));
            count++;
        }
    }
}
