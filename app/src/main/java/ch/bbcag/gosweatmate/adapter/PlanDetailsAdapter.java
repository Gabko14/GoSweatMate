package ch.bbcag.gosweatmate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ch.bbcag.gosweatmate.R;
import ch.bbcag.gosweatmate.helper.ExerciseModelStorage;

public class AddExerciseGalleryAdapter extends RecyclerView.Adapter<AddExerciseGalleryAdapter.ViewHolder> {
    private final List<ExerciseModelStorage> exerciseModel;
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public Button addBtn;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            addBtn = (Button) v.findViewById(R.id.addButton);
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

    public AddExerciseGalleryAdapter(List<ExerciseModelStorage> myDataset) {
        exerciseModel = myDataset;
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
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("12345678987654321 187");            }
        });

        holder.txtFooter.setText("Footer: " + currentModel.getName() + " id: " + currentModel.getId());


    }


    @Override
    public int getItemCount() {
        return exerciseModel.size();
    }


}

