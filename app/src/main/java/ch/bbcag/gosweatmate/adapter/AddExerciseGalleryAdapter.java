package ch.bbcag.gosweatmate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ch.bbcag.gosweatmate.R;
import ch.bbcag.gosweatmate.helper.ExerciseModelStorage;
import ch.bbcag.gosweatmate.helper.SelectListener;

public class AddExerciseGalleryAdapter extends RecyclerView.Adapter<AddExerciseGalleryAdapter.ViewHolder> {
    private final List<ExerciseModelStorage> exerciseModel;
    private SelectListener listener;
    private Context context;

    public AddExerciseGalleryAdapter(Context context, List<ExerciseModelStorage> exerciseModel, SelectListener listener) {
        this.exerciseModel = exerciseModel;
        this.listener = listener;
        this.context = context;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public RelativeLayout relativeLayout;
        public Button addBtn;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.main_container);

        }
    }

    public void add(int position, ExerciseModelStorage item) {
        exerciseModel.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        exerciseModel.remove(position);
        notifyItemRemoved(position);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final ExerciseModelStorage currentModel = exerciseModel.get(position);
        holder.txtHeader.setText(currentModel.getName());

        holder.txtFooter.setText("Footer: " + currentModel.getName() + " id: " + currentModel.getId());

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(exerciseModel.get(holder.getBindingAdapterPosition()));
            }
        });


    }


    @Override
    public int getItemCount() {
        return exerciseModel.size();
    }


}

