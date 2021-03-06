package com.ywl5320.wlivetv.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ywl5320.wlivetv.Entity.VideoBean;
import com.ywl5320.wlivetv.R;
import java.util.List;

/**
 * Created by ywl on 15-10-12.
 */
public class VideoAdapter extends BaseDataAdapter{


    public VideoAdapter(Context context, List<VideoBean> mDatas, ListView listView) {
        super(context, mDatas);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        final VideoBean liveBean = (VideoBean) mDatas.get(position);
        if (convertView == null) {
            convertView = mlayoutInflate.inflate(R.layout.live_listview_adapter_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.ivImg = (ImageView) convertView.findViewById(R.id.iv_img);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(liveBean.getTvName());

        viewHolder.ivImg.setTag(liveBean.getTvUrl());
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(liveBean.getTvUrl(), viewHolder.ivImg, options, null);

        return convertView;
    }

    public void updateDatas(List<VideoBean> datas) {
        this.mDatas = datas;
        notifyDataSetChanged();
    }

    public class ViewHolder {
        public TextView tvName;
        public ImageView ivImg;
    }

}
