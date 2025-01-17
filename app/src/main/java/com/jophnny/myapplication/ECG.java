package com.jophnny.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
//import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ECG extends Fragment {

    private OnFragmentInteractionListener mListener;

    int p1p = 0;
    int p1ppt = -20;
    int p2p = 0;
    int p2ppt = -20;

    public ECG() {
        // Required empty public constructor
    }

    public static ECG newInstance() {
        ECG fragment = new ECG();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ecg, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    // This is where the programmatically instantiated items sit
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView textItem = view.findViewById(R.id.text_box);
        textItem.setMovementMethod(new ScrollingMovementMethod());

        ImageButton card1 = (ImageButton) view.findViewById(R.id.card1);
        ImageButton card2 = (ImageButton) view.findViewById(R.id.card2);
        a = CardSelector(unselectable); // Selects cards for both players' hands
        card1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hand1[0] = cards[a];
                unselectable[a] = true;
                a = CardSelector(unselectable);
                hand1[1] = cards[a];
                unselectable[a] = true;
                a = CardSelector(unselectable);
                hand2[0] = cards[a];
                unselectable[a] = true;
                a = CardSelector(unselectable);
                hand2[1] = cards[a];
                unselectable[a] = true;
                p1p = p1p - p1ppt;
                p2p = p2p - p2ppt;
                Game(cards, view);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hand1[0] = cards[a];
                unselectable[a] = true;
                a = CardSelector(unselectable);
                hand1[1] = cards[a];
                unselectable[a] = true;
                a = CardSelector(unselectable);
                hand2[0] = cards[a];
                unselectable[a] = true;
                a = CardSelector(unselectable);
                hand2[1] = cards[a];
                unselectable[a] = true;
                p1p = p1p - p1ppt;
                p2p = p2p - p2ppt;
                Game(cards, view);
            }
        });
    }

    final int[] choice = new int[1];
    final String[] cards = new String[]{"1 of Oils", "2 of Oils", "3 of Oils", "4 of Oils", "5 of Oils", "6 of Oils",
            "1 of Renewables", "2 of Renewables", "3 of Renewables", "4 of Renewables", "5 of Renewables", "6 of Renewables",
            "1 of Industrials", "2 of Industrials", "3 of Industrials", "4 of Industrials", "5 of Industrials", "6 of Industrials",
            "1 of Botany", "2 of Botany", "3 of Botany", "4 of Botany", "5 of Botany", "6 of Botany"};
    String[] hand1 = new String[2];
    String[] hand2 = new String[2];
    boolean[] unselectable = new boolean[24];
    boolean P1turn = true;
    boolean gaming = true;
    int turncount = 1;
    int a;
// TODO add instructions

    int GetDrawableID(String name) {
        if (name.equals("1 of Oils")) {return R.drawable.oils1;}
        else if (name.equals("2 of Oils")) {return R.drawable.oils2;}
        else if (name.equals("3 of Oils")) {return R.drawable.oils3;}
        else if (name.equals("4 of Oils")) {return R.drawable.oils4;}
        else if (name.equals("5 of Oils")) {return R.drawable.oils5;}
        else if (name.equals("6 of Oils")) {return R.drawable.oils6;}
        else if (name.equals("1 of Industrials")) {return R.drawable.industrials1;}
        else if (name.equals("2 of Industrials")) {return R.drawable.industrials2;}
        else if (name.equals("3 of Industrials")) {return R.drawable.industrials3;}
        else if (name.equals("4 of Industrials")) {return R.drawable.industrials4;}
        else if (name.equals("5 of Industrials")) {return R.drawable.industrials5;}
        else if (name.equals("6 of Industrials")) {return R.drawable.industrials6;}
        else if (name.equals("1 of Renewables")) {return R.drawable.renewables1;}
        else if (name.equals("2 of Renewables")) {return R.drawable.renewables2;}
        else if (name.equals("3 of Renewables")) {return R.drawable.renewables3;}
        else if (name.equals("4 of Renewables")) {return R.drawable.renewables4;}
        else if (name.equals("5 of Renewables")) {return R.drawable.renewables5;}
        else if (name.equals("6 of Renewables")) {return R.drawable.renewables6;}
        else if (name.equals("1 of Botany")) {return R.drawable.botany1;}
        else if (name.equals("2 of Botany")) {return R.drawable.botany2;}
        else if (name.equals("3 of Botany")) {return R.drawable.botany3;}
        else if (name.equals("4 of Botany")) {return R.drawable.botany4;}
        else if (name.equals("5 of Botany")) {return R.drawable.botany5;}
        else {return R.drawable.botany6;}
    }

    void Game(final String[] cards, @NonNull final View view) { // Operates the game
        final TextView textItem = view.findViewById(R.id.text_box);
        ImageButton card1 = (ImageButton) view.findViewById(R.id.card1);
        ImageButton card2 = (ImageButton) view.findViewById(R.id.card2);
        if (gaming) {
            if (P1turn && (choice[0] == 0)) {
                textItem.append("Turn: " + turncount + "    ");
                textItem.append("\n" + "Player 1, play a card!");
                textItem.append("\n" + hand1[0]+ "   ");
                textItem.append(hand1[1]);
                p1p = p1p + p1ppt;
                textItem.append("\n" + "Current Pollution Point: " + p1p + ", Point Change Per Turn: " + p1ppt + ".");
                card1.setImageResource(GetDrawableID(hand1[0]));
                card2.setImageResource(GetDrawableID(hand1[1]));
                card1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        choice[0] = 1;
                        Game(cards,view);
                    }
                });
                card2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        choice[0] = 2;
                        Game(cards,view);
                    }
                });
            } else if (P1turn && (choice[0] != 0)) {
                CardEffect(1, hand1[choice[0] - 1]);
                P1turn = false;
                try {
                    a = CardSelector(unselectable);}
                catch (Exception e) {Win(false, view); gaming = false;} // Finish game if cards run out
                hand1[choice[0] - 1] = cards[a];
                unselectable[a] = true;
                for (int j = 0; j < 5; j++) {textItem.append("\n");}
                choice[0] = 0;
                if (p1ppt >= 0) {Win(true, view); gaming = false;} // Finish game if one person nets a "net zero"
                Game(cards,view);
            } else if (!P1turn && (choice[0] == 0)) {
                textItem.append("Turn: " + turncount + "    ");
                textItem.append("\n" + "Player 2, play a card!");
                textItem.append("\n" + hand2[0] + "   ");
                textItem.append(hand2[1]);
                p2p = p2p + p2ppt;
                textItem.append("\n" + "Current Pollution Point: " + p2p + ", Point Change Per Turn: " + p2ppt + ".");
                card1.setImageResource(GetDrawableID(hand2[0]));
                card2.setImageResource(GetDrawableID(hand2[1]));
                card1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        choice[0] = 1;
                        Game(cards,view);
                    }
                });
                card2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        choice[0] = 2;
                        Game(cards,view);
                    }
                });
            } else if (!P1turn && (choice[0] != 0)) {
                CardEffect(2, hand1[choice[0] - 1]);
                P1turn = true;
                try {
                    a = CardSelector(unselectable);}
                catch (Exception e) {Win(false, view); gaming = false;} // Finish game if cards run out
                hand2[choice[0]-1] = cards[a];
                unselectable[a] = true;
                for (int j = 0; j < 5; j++) {textItem.append("\n");}
                choice[0] = 0;
                turncount++;
                if (p2ppt >= 0) {Win(true, view); gaming = false;} // Finish game if one person nets a "net zero"
                Game(cards,view);
            }
        } else {
            textItem.append("\n" + "This game has ended.");
            card1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {}});
            card2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {}});
        }
    }
    private static int CardSelector(boolean[] cardset) { // Picks an integer at random, it is later converted to a String, ex. 23
        Random rdn = new Random();
        List<String> cardsel = new ArrayList<String>();
        for (int i = 0; i < 24; i++)
        {
            if (!cardset[i])
                cardsel.add(Integer.toString(i));
        }
        String[] cardsout = (String[]) cardsel.toArray(new String[0]);
        return Integer.parseInt(cardsout[rdn.nextInt(cardsout.length)]);
    }
    void CardEffect(int player, String card) { // Activates a card effect for the player dealing it
        if (player == 1) {
            if (card == "1 of Oils") {p1p = p1p + 1; p1ppt = p1ppt - 1;} else
            if (card == "2 of Oils") {p1p = p1p + 2; p1ppt = p1ppt - 1;} else
            if (card == "3 of Oils") {p1p = p1p + 2; p1ppt = p1ppt - 2;} else
            if (card == "4 of Oils") {p1p = p1p + 3; p1ppt = p1ppt - 2;} else
            if (card == "5 of Oils") {p1p = p1p + 4; p1ppt = p1ppt - 2;} else
            if (card == "6 of Oils") {p1p = p1p + 5; p1ppt = p1ppt - 2;} else
            if (card == "1 of Renewables") {p1p = p1p + 1; p1ppt = p1ppt + 1;} else
            if (card == "2 of Renewables") {p1p = p1p + 2; p1ppt = p1ppt + 1;} else
            if (card == "3 of Renewables") {p1p = p1p + 2; p1ppt = p1ppt + 2;} else
            if (card == "4 of Renewables") {p1p = p1p + 3; p1ppt = p1ppt + 2;} else
            if (card == "5 of Renewables") {p1p = p1p + 4; p1ppt = p1ppt + 2;} else
            if (card == "6 of Renewables") {p1p = p1p + 5; p1ppt = p1ppt + 2;} else
            if (card == "1 of Industrials") {p1p = p1p + 5; p1ppt = p1ppt - 3;} else
            if (card == "2 of Industrials") {p1p = p1p + 6; p1ppt = p1ppt - 3;} else
            if (card == "3 of Industrials") {p1p = p1p + 7; p1ppt = p1ppt - 4;} else
            if (card == "4 of Industrials") {p1p = p1p + 8; p1ppt = p1ppt - 4;} else
            if (card == "5 of Industrials") {p1p = p1p + 9; p1ppt = p1ppt - 5;} else
            if (card == "6 of Industrials") {p1p = p1p + 10; p1ppt = p1ppt - 5;} else
            if (card == "1 of Botany") {p1p = p1p + 5; p1ppt = p1ppt + 3;} else
            if (card == "2 of Botany") {p1p = p1p + 6; p1ppt = p1ppt + 3;} else
            if (card == "3 of Botany") {p1p = p1p + 7; p1ppt = p1ppt + 4;} else
            if (card == "4 of Botany") {p1p = p1p + 8; p1ppt = p1ppt + 4;} else
            if (card == "5 of Botany") {p1p = p1p + 9; p1ppt = p1ppt + 5;} else
            if (card == "6 of Botany") {p1p = p1p + 10; p1ppt = p1ppt + 5;} else {System.out.println(card);}
        } else {
            if (card == "1 of Oils") {p2p = p2p + 1; p2ppt = p2ppt + 1;} else
            if (card == "2 of Oils") {p2p = p2p + 2; p2ppt = p2ppt + 1;} else
            if (card == "3 of Oils") {p2p = p2p + 2; p2ppt = p2ppt + 2;} else
            if (card == "4 of Oils") {p2p = p2p + 3; p2ppt = p2ppt + 2;} else
            if (card == "5 of Oils") {p2p = p2p + 4; p2ppt = p2ppt + 2;} else
            if (card == "6 of Oils") {p2p = p2p + 5; p2ppt = p2ppt + 2;} else
            if (card == "1 of Renewables") {p2p = p2p + 1; p2ppt = p2ppt - 1;} else
            if (card == "2 of Renewables") {p2p = p2p + 2; p2ppt = p2ppt - 1;} else
            if (card == "3 of Renewables") {p2p = p2p + 2; p2ppt = p2ppt - 2;} else
            if (card == "4 of Renewables") {p2p = p2p + 3; p2ppt = p2ppt - 2;} else
            if (card == "5 of Renewables") {p2p = p2p + 4; p2ppt = p2ppt - 2;} else
            if (card == "6 of Renewables") {p2p = p2p + 5; p2ppt = p2ppt - 2;} else
            if (card == "1 of Industrials") {p2p = p2p + 5; p2ppt = p2ppt + 3;} else
            if (card == "2 of Industrials") {p2p = p2p + 6; p2ppt = p2ppt + 3;} else
            if (card == "3 of Industrials") {p2p = p2p + 7; p2ppt = p2ppt + 4;} else
            if (card == "4 of Industrials") {p2p = p2p + 8; p2ppt = p2ppt + 4;} else
            if (card == "5 of Industrials") {p2p = p2p + 9; p2ppt = p2ppt + 5;} else
            if (card == "6 of Industrials") {p2p = p2p + 10; p2ppt = p2ppt + 5;} else
            if (card == "1 of Botany") {p2p = p2p + 5; p2ppt = p2ppt - 3;} else
            if (card == "2 of Botany") {p2p = p2p + 6; p2ppt = p2ppt - 3;} else
            if (card == "3 of Botany") {p2p = p2p + 7; p2ppt = p2ppt - 4;} else
            if (card == "4 of Botany") {p2p = p2p + 8; p2ppt = p2ppt - 4;} else
            if (card == "5 of Botany") {p2p = p2p + 9; p2ppt = p2ppt - 5;} else
            if (card == "6 of Botany") {p2p = p2p + 10; p2ppt = p2ppt - 5;} else {System.out.println(card);}
        }
    }
    void Win(boolean trueWin, @NonNull View view)
    {
        final TextView textItem = view.findViewById(R.id.text_box);
        ImageButton card1 = (ImageButton) view.findViewById(R.id.card1);
        ImageButton card2 = (ImageButton) view.findViewById(R.id.card2);
        card1.setImageResource(0);
        card2.setImageResource(0);
        if (trueWin) {
            if (p2p < p1p)
            {
                if (p1ppt > p2ppt) {textItem.append("Player 1 has won! They had won despite Player 2's world cleaning efforts.");}
                else if (p1ppt < p2ppt) {textItem.append("Player 1 has won! They won an astounding victory!");}
                else if (p1ppt == p2ppt) {textItem.append("Player 1 has won!");}
                else {textItem.append(p1ppt + "    " + p2ppt);}
            }
            else if (p1p < p2p)
            {
                if (p1ppt > p2ppt) {textItem.append("Player 2 has won! They won an astounding victory!");}
                else if (p1ppt < p2ppt) {textItem.append("Player 2 has won! They had won despite Player 1's world cleaning efforts.");}
                else if (p1ppt == p2ppt) {textItem.append("Player 2 has won!");}
                else {textItem.append(p1ppt + "    " + p2ppt);}
            }
            else {textItem.append(p1ppt + "    " + p2ppt);} // Error Line
        }
        else
        {
            textItem.append("\n" + "No Cards Left!" + "\n"); // No Card Win
            if (p1p < p2p) {textItem.append("Player 1 won! They had less pollution when the cards had ran out.");}
            if (p1p > p2p) {textItem.append("Player 2 won! They had less pollution when the cards had ran out.");}
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
