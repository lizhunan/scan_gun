package com.ctrl.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseListAdapter<T> extends RecyclerView.Adapter<BaseListAdapter.BaseViewHolder> {


    protected Context mContext;
    private LayoutInflater mInflater;
    protected List<T> mDataList = new ArrayList<>();

    protected OnItemClickListener<T> mOnItemClickListener;

    public OnItemClickListener<T> getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener<T> mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public BaseListAdapter(Context mContext) {
        this.mContext = mContext;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(getLayoutId(), viewGroup, false);
        return new BaseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( BaseListAdapter.BaseViewHolder viewHolder, int i) {
        onBindItemHolder(viewHolder, i);
    }


    @Override
    public int getItemCount() {
        if (mDataList != null) {
            return mDataList.size();
        } else {
            return 0;
        }
    }

    public List<T> getDataList() {
        return mDataList;
    }

    public void addAll(Collection<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int lastIndex = this.mDataList.size();
        if (this.mDataList.addAll(list)) {
            notifyItemRangeInserted(lastIndex, list.size());
        }
    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     *
     * @param orgs
     */
    public void updateListView(List<T> orgs) {
        if (orgs == null) {
            this.mDataList = new ArrayList<T>();
        } else {
            this.mDataList = orgs;
        }
        notifyDataSetChanged();
    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }

    public abstract int getLayoutId();

    public abstract void onBindItemHolder(BaseViewHolder holder, int position);

    public interface OnItemClickListener<T> {
        void onItemClick(T t, int position);
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
