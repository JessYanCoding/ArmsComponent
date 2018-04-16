/*
 * Copyright 2018 JessYan
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
package me.jessyan.armscomponent.commonsdk.http;

/**
 * ================================================
 * CommonSDK 的 Api 可以定义公用的关于 API 的相关常量, 比如说请求地址, 错误码等, 每个组件的 Api 可以定义组件自己的私有常量
 *
 * Created by JessYan on 30/03/2018 17:16
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface Api {
    String APP_DOMAIN = "https://api.github.com";

    String REQUEST_SUCCESS = "200";

    // 错误码
    String ERROR_USER_INCORRECT = "1001";
    String ERROR_PHONE_EXIST = "1019";
    String VALIDATION_OVERTIME = "1020";
    String NOT_PERMISSIONS = "403";
    String API_EXCPTION = "500";
    String REQUEST_PARAM_INCORRECT = "1000";
    String VADATION_INCORRECT = "1002";
    String FIRST_STOP_AFTER_DELETE = "1003";
    String UPLOADING_FILE_OVERSIZE = "1004";
    String EDIT_COMMO_LEVEL = "1005";
    String COMMO_CLASS_RE = "1006";
    String COMMO_TRADEMARK_RE = "1007";
    String LOGISTICS_TEMPLATE_RE = "1008";
    String COMMO_ATTRIBUTE_RE = "1009";
    String USER_NOT_REGISTER = "1010";
    String USER_ALREADY_ADD = "1011";
    String COMMO_CLASS_DELETE = "1012";
    String COMMO_TRANDMARK_DELETE = "1013";
    String COMMO_STORE_OFF = "1014";
    String USER_FORBIDDEN = "1015";
    String ONLY_FIVE_OPERATION = "1024";
    String NAME_ONE_MODIFICATION = "1017";
    String NAME_EXIST = "1018";
    String FIVE_ERR_PWDD = "1016";
    String PWD_NOT_LIKE = "1053";
    String BINDPHONELIKE = "1025";
    String MODIFICOUNTTHREE = "1026";
    String MODIFIPHONEOVERTHREE = "1027";
    String NOTLOGININ = "1052";
    String PASSOWRDINCOREECT = "1055";
    String NOTMATCHIMGBANKCARD = "1041";
    String IDCARDEXIT = "1038";
    String STORENAMEEXIT = "1028";
    String COMPANYNAMEEXIT = "1030";
    String CODEEXIT = "1029";
    String BANKREPETION = "1074";
    String REPETITION = "1032";
    String SERIVENULL ="1044";
    String LIMITMESSAGE = "1082";
    String NO_DEAL = "1081";
}
