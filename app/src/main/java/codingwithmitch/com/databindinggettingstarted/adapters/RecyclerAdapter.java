package codingwithmitch.com.databindinggettingstarted.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.*;

import codingwithmitch.com.databindinggettingstarted.R;
import codingwithmitch.com.databindinggettingstarted.models.NicePlace;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NicePlace> mNicePlaces = new ArrayList<>();
    private Context mContext;
    public RecyclerAdapter(Context context, ArrayList<NicePlace> nicePlaces) {
        mNicePlaces = nicePlaces;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent);
       return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //Set the name of the 'NicePlace'
       ViewHolder.setText(mNicePlaces.get(position).getTitle());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private static String mName;
        public ViewHolder(View view) {
            super(view);
        }

        public static void setText(String aName){
            mName = aName;
        }
    }
}
