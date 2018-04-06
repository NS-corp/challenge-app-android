package corp.ns.challenge_app_android.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import corp.ns.challenge_app_android.RequestData.Data.ChallengeInfo;
import corp.ns.challengeapplication.R;

public class ChallengeRecyclerAdapter
        extends RecyclerView.Adapter<ChallengeRecyclerAdapter.ViewHolder>{
    private List<ChallengeInfo> mChallenges;

    // класс view holder-а с помощью которого мы получаем ссылку на каждый элемент
    // отдельного пункта списка
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // наш пункт состоит только из одного TextView
        public TextView mChallengeNameTextView;

        public ViewHolder(View v) {
            super(v);
            mChallengeNameTextView = v.findViewById(R.id.challenge_name);
        }
    }

    // Конструктор
    public ChallengeRecyclerAdapter(List<ChallengeInfo> challenges) {
        mChallenges = challenges;
    }

    // Создает новые views (вызывается layout manager-ом)
    @Override
    public ChallengeRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.challenge_view, parent, false);

        // тут можно программно менять атрибуты лэйаута (size, margins, paddings и др.)

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Заменяет контент отдельного view (вызывается layout manager-ом)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ChallengeInfo challengeInfo = mChallenges.get(position);
        holder.mChallengeNameTextView.setText(challengeInfo.getName());

    }

    // Возвращает размер данных (вызывается layout manager-ом)
    @Override
    public int getItemCount() {
        return mChallenges.size();
    }
}
