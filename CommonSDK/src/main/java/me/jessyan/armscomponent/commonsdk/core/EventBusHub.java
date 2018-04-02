/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.jessyan.armscomponent.commonsdk.core;

/**
 * ================================================
 * EventBusHub 用来定义 AndroidEventBus 的 Tag 字符串, 以组件名作为 Tag 前缀, 对每个组件的事件进行分组
 * Tag 的命名规则为 组件名 + 页面名 + 动作
 * 比如需要使用 AndroidEventBus 通知订单组件的订单详情页进行刷新, 可以将这个刷新方法的 Tag 命名为 "order/OrderDetailActivity/refresh"
 *
 * Created by JessYan on 30/03/2018 17:46
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface EventBusHub {
}
