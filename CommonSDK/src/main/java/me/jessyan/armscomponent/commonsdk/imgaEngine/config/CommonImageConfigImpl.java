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
package me.jessyan.armscomponent.commonsdk.imgaEngine.config;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.jess.arms.http.imageloader.ImageConfig;

/**
 * ================================================
 * Created by JessYan on 30/03/2018 17:16
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public class CommonImageConfigImpl extends ImageConfig {
    private int cacheStrategy;//0对应DiskCacheStrategy.all,1对应DiskCacheStrategy.NONE,2对应DiskCacheStrategy.SOURCE,3对应DiskCacheStrategy.RESULT
    private int fallback; //请求 url 为空,则使用此图片作为占位符
    private BitmapTransformation transformation;//glide用它来改变图形的形状
    private ImageView[] imageViews;
    private boolean isClearMemory;//清理内存缓存
    private boolean isClearDiskCache;//清理本地缓存
    private Drawable placeholderDrawble;
    private int resizeX;
    private boolean isCropCenter;
    private boolean isCropCircle;
    private boolean isFitCenter;
    private DecodeFormat formate;//图片格式
    private int resizeY;
    private int imageRadius;//图片每个圆角的大小
    private int blurValue;//高斯模糊值, 值越大模糊效果越大
    private boolean isCrossFade;//是否使用淡入淡出过渡动画

    private CommonImageConfigImpl(Builder builder) {
        this.url = builder.url;
        this.imageView = builder.imageView;
        this.placeholder = builder.placeholder;
        this.placeholderDrawble = builder.placeholderDrawble;
        this.errorPic = builder.errorPic;
        this.fallback = builder.fallback;
        this.cacheStrategy = builder.cacheStrategy;
        this.transformation = builder.transformation;
        this.imageViews = builder.imageViews;
        this.isClearMemory = builder.isClearMemory;
        this.isClearDiskCache = builder.isClearDiskCache;
        this.resizeX = builder.resizeX;
        this.resizeY = builder.resizeY;
        this.isCropCenter = builder.isCropCenter;
        this.isCropCircle = builder.isCropCircle;
        this.formate = builder.formate;
        this.isFitCenter = builder.isFitCenter;
        this.isCrossFade = builder.isCrossFade;
        this.imageRadius = builder.imageRadius;
        this.blurValue = builder.blurValue;
    }

    public int getCacheStrategy() {
        return cacheStrategy;
    }

    public BitmapTransformation getTransformation() {
        return transformation;
    }

    public ImageView[] getImageViews() {
        return imageViews;
    }

    public boolean isClearMemory() {
        return isClearMemory;
    }

    public boolean isClearDiskCache() {
        return isClearDiskCache;
    }

    public int getFallback() {
        return fallback;
    }

    public Drawable getPlaceHolderDrawble() {
        return placeholderDrawble;
    }
    public int getResizeX(){
        return resizeX;
    }
    public int getResizeY(){
        return resizeY;
    }
    public boolean isCropCenter(){
        return isCropCenter;
    }
    public boolean isCropCircle(){
        return isCropCircle;
    }
    public DecodeFormat decodeFormate(){
        return  formate;
    }
    public boolean isFitCenter(){
        return isFitCenter;
    }
    public boolean isCrossFade() {
        return isCrossFade;
    }
    public int getBlurValue() {
        return blurValue;
    }

    public boolean isBlurImage() {
        return blurValue > 0;
    }

    public int getImageRadius() {
        return imageRadius;
    }

    public boolean isImageRadius() {
        return imageRadius > 0;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private int resizeX;
        private String url;
        private ImageView imageView;
        private int placeholder;
        private Drawable placeholderDrawble;
        private int errorPic;
        private int fallback; //请求 url 为空,则使用此图片作为占位符
        private int cacheStrategy;//0对应DiskCacheStrategy.all,1对应DiskCacheStrategy.NONE,2对应DiskCacheStrategy.SOURCE,3对应DiskCacheStrategy.RESULT
        private int imageRadius;//图片每个圆角的大小
        private int blurValue;//高斯模糊值, 值越大模糊效果越大
        private BitmapTransformation transformation;//glide用它来改变图形的形状
        private ImageView[] imageViews;
        private boolean isClearMemory;//清理内存缓存
        private boolean isClearDiskCache;//清理本地缓存
        private boolean isCropCenter;//裁剪居中
        private boolean isCropCircle;
        private boolean isCrossFade;//是否使用淡入淡出过渡动画
        public DecodeFormat formate;
        public boolean isFitCenter;
        private int resizeY;

        private Builder() {
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder placeholder(int placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        public Builder errorPic(int errorPic) {
            this.errorPic = errorPic;
            return this;
        }

        public Builder fallback(int fallback) {
            this.fallback = fallback;
            return this;
        }

        public Builder imageView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public Builder cacheStrategy(int cacheStrategy) {
            this.cacheStrategy = cacheStrategy;
            return this;
        }

        public Builder imageRadius(int imageRadius) {
            this.imageRadius = imageRadius;
            return this;
        }

        public Builder blurValue(int blurValue) { //blurValue 建议设置为 15
            this.blurValue = blurValue;
            return this;
        }

        public Builder isCrossFade(boolean isCrossFade) {
            this.isCrossFade = isCrossFade;
            return this;
        }

        public Builder transformation(BitmapTransformation transformation) {
            this.transformation = transformation;
            return this;
        }

        public Builder imageViews(ImageView... imageViews) {
            this.imageViews = imageViews;
            return this;
        }

        public Builder isClearMemory(boolean isClearMemory) {
            this.isClearMemory = isClearMemory;
            return this;
        }

        public Builder isClearDiskCache(boolean isClearDiskCache) {
            this.isClearDiskCache = isClearDiskCache;
            return this;
        }

        public Builder placeholderDrawble(Drawable placeholderDrawble) {
            this.placeholderDrawble = placeholderDrawble;
            return this;
        }
        public Builder resize(int resizeX,int resizeY){
            this.resizeX = resizeX;
            this.resizeY = resizeY;
            return this;
        }

        public Builder isCropCenter(boolean isCropCenter){
            this.isCropCenter = isCropCenter;
            return this;
        }

        public Builder isCropCircle(boolean isCropCircle){
            this.isCropCircle = isCropCircle;
            return this;
        }
        public Builder setDecodeFormate(DecodeFormat decodeFormate){
            formate = decodeFormate;
            return this;
        }

        public Builder isFitCenter(boolean isFitCenter){
            this.isFitCenter = isFitCenter;
            return this;
        }
        public CommonImageConfigImpl build() {
            return new CommonImageConfigImpl(this);
        }
    }
}
