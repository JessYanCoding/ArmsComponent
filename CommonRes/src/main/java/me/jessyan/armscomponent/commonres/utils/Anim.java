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
package me.jessyan.armscomponent.commonres.utils;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import me.jessyan.armscomponent.commonres.R;


/**
 * ================================================
 * 动画工具类
 * <p>
 * Created by JessYan on 27/04/2017 21:40
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class Anim {
    public static void exit(Activity obj) {
        obj.overridePendingTransition(R.anim.public_translate_left_to_center, R.anim.public_translate_center_to_right);
    }

    public static void in(Activity obj) {
        obj.overridePendingTransition(R.anim.public_translate_right_to_center, R.anim.public_translate_center_to_left);
    }

    public static void cleanAnim(ImageView animView) {
        if (animView == null)
            return;
        animView.setImageResource(0);
        animView.clearAnimation();
        animView.setVisibility(View.GONE);
    }
}
