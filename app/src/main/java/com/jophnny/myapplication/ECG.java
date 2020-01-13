package com.jophnny.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ECG.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ECG#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ECG extends Fragment {

    private OnFragmentInteractionListener mListener;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button card1 = (Button) view.findViewById(R.id.card1);
        Button card2 = (Button) view.findViewById(R.id.card2);
        final TextView textItem = view.findViewById(R.id.text_box);
        textItem.setMovementMethod(new ScrollingMovementMethod());

        int p1p = 0;
        int p1ppt = -20;
        int p2p = 0;
        int p2ppt = -20;
        String[] cards = new String[]{"1 of Oils", "2 of Oils", "3 of Oils", "4 of Oils", "5 of Oils", "6 of Oils",
                "1 of Renewables", "2 of Renewables", "3 of Renewables", "4 of Renewables", "5 of Renewables", "6 of Renewables",
                "1 of Industrials", "2 of Industrials", "3 of Industrials", "4 of Industrials", "5 of Industrials", "6 of Industrials",
                "1 of Botany", "2 of Botany", "3 of Botany", "4 of Botany", "5 of Botany", "6 of Botany"};
//        Game(cards);

        card1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textItem.append("Card 1");
                textItem.append("\n");
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textItem.append("Card 2");
                textItem.append("\n");
            }
        });
    }

//    static void Game(string[] cards) { // Operates the game
//        string[] hand1 = new string[2];
//        string[] hand2 = new string[2];
//        bool[] unselectable = new bool[cards.Length];
//        bool P1turn = true;
//        bool gaming = true;
//        int turncount = 1;
//        int choice;
//        int a;
//        for (int j = 0; j < 10; j++) {Console.WriteLine();}
//        a = CardSelector(unselectable); // Selects cards for both players' hands
//        hand1[0] = cards[a];
//        unselectable[a] = true;
//        a = CardSelector(unselectable);
//        hand1[1] = cards[a];
//        unselectable[a] = true;
//        a = CardSelector(unselectable);
//        hand2[0] = cards[a];
//        unselectable[a] = true;
//        a = CardSelector(unselectable);
//        hand2[1] = cards[a];
//        unselectable[a] = true;
//        p1p = p1p - p1ppt;
//        p2p = p2p - p2ppt;
//        while (gaming) {
//            if (P1turn) {
//                Console.Write("Turn: {0}    ", turncount);
//                Console.WriteLine("Player 1, play a card!");
//                Console.Write(hand1[0]+ "   ");
//                Console.WriteLine(hand1[1]);
//                p1p = p1p + p1ppt;
//                Console.WriteLine("Current Pollution Point: {0}, Point Change Per Turn: {1}.", p1p, p1ppt);
//                choice = Convert.ToInt32(Console.ReadLine());
//                if (choice == -1) {gaming = false;} else {
//                    CardEffect(1, hand1[choice - 1]);
//                    P1turn = false;
//                    try {a = CardSelector(unselectable);}
//                    catch {Win(false); gaming = false;} // Finish game if cards run out
//                    hand1[choice-1] = cards[a];
//                    unselectable[a] = true; }
//                for (int j = 0; j < 10; j++) {Console.WriteLine();}
//                if (p1ppt >= 0) {Win(true); gaming = false;} // Finish game if one person nets a "net zero"
//            } else {
//                Console.Write("Turn: {0}    ", turncount);
//                Console.WriteLine("Player 2, play a card!");
//                Console.Write(hand2[0]+ "   ");
//                Console.WriteLine(hand2[1]);
//                p2p = p2p + p2ppt;
//                Console.WriteLine("Current Pollution Point: {0}, Point Change Per Turn: {1}.", p2p, p2ppt);
//                choice = Convert.ToInt32(Console.ReadLine());
//                if (choice == -1) {gaming = false;} else {
//                    CardEffect(2, hand1[choice - 1]);
//                    P1turn = true;
//                    try {a = CardSelector(unselectable);}
//                    catch {Win(false); gaming = false;} // Finish game if cards run out
//                    hand2[choice-1] = cards[a];
//                    unselectable[a] = true; }
//                for (int j = 0; j < 10; j++) {Console.WriteLine();}
//                turncount++;
//                if (p2ppt >= 0) {Win(true); gaming = false;} // Finish game if one person nets a "net zero"
//            }
//        }
//    }
//    static int CardSelector(bool[] cardset) { // Picks an integer at random, it is later converted to a string, ex. 23
//        Random rdn = new Random();
//        List<string> cardsel = new List<string>();
//        for (int i = 0; i < cardset.Length; i++)
//        {
//            if (!cardset[i])
//                cardsel.Add(Convert.ToString(i));
//        }
//        string[] cardsout = cardsel.ToArray();
//        return Convert.ToInt32(cardsout[rdn.Next(cardsout.Length)]);
//    }
//    static void CardEffect(int player, string card) { // Activates a card effect for the player dealing it
//        if (player == 1) {
//            if (card == "1 of Oils") {p1p = p1p + 1; p1ppt = p1ppt - 1;} else
//            if (card == "2 of Oils") {p1p = p1p + 2; p1ppt = p1ppt - 1;} else
//            if (card == "3 of Oils") {p1p = p1p + 2; p1ppt = p1ppt - 2;} else
//            if (card == "4 of Oils") {p1p = p1p + 3; p1ppt = p1ppt - 2;} else
//            if (card == "5 of Oils") {p1p = p1p + 4; p1ppt = p1ppt - 2;} else
//            if (card == "6 of Oils") {p1p = p1p + 5; p1ppt = p1ppt - 2;} else
//            if (card == "1 of Renewables") {p1p = p1p + 1; p1ppt = p1ppt + 1;} else
//            if (card == "2 of Renewables") {p1p = p1p + 2; p1ppt = p1ppt + 1;} else
//            if (card == "3 of Renewables") {p1p = p1p + 2; p1ppt = p1ppt + 2;} else
//            if (card == "4 of Renewables") {p1p = p1p + 3; p1ppt = p1ppt + 2;} else
//            if (card == "5 of Renewables") {p1p = p1p + 4; p1ppt = p1ppt + 2;} else
//            if (card == "6 of Renewables") {p1p = p1p + 5; p1ppt = p1ppt + 2;} else
//            if (card == "1 of Industrials") {p1p = p1p + 5; p1ppt = p1ppt - 3;} else
//            if (card == "2 of Industrials") {p1p = p1p + 6; p1ppt = p1ppt - 3;} else
//            if (card == "3 of Industrials") {p1p = p1p + 7; p1ppt = p1ppt - 4;} else
//            if (card == "4 of Industrials") {p1p = p1p + 8; p1ppt = p1ppt - 4;} else
//            if (card == "5 of Industrials") {p1p = p1p + 9; p1ppt = p1ppt - 5;} else
//            if (card == "6 of Industrials") {p1p = p1p + 10; p1ppt = p1ppt - 5;} else
//            if (card == "1 of Botany") {p1p = p1p + 5; p1ppt = p1ppt + 3;} else
//            if (card == "2 of Botany") {p1p = p1p + 6; p1ppt = p1ppt + 3;} else
//            if (card == "3 of Botany") {p1p = p1p + 7; p1ppt = p1ppt + 4;} else
//            if (card == "4 of Botany") {p1p = p1p + 8; p1ppt = p1ppt + 4;} else
//            if (card == "5 of Botany") {p1p = p1p + 9; p1ppt = p1ppt + 5;} else
//            if (card == "6 of Botany") {p1p = p1p + 10; p1ppt = p1ppt + 5;} else {Console.WriteLine(card);}
//        } else {
//            if (card == "1 of Oils") {p2p = p2p + 1; p2ppt = p2ppt + 1;} else
//            if (card == "2 of Oils") {p2p = p2p + 2; p2ppt = p2ppt + 1;} else
//            if (card == "3 of Oils") {p2p = p2p + 2; p2ppt = p2ppt + 2;} else
//            if (card == "4 of Oils") {p2p = p2p + 3; p2ppt = p2ppt + 2;} else
//            if (card == "5 of Oils") {p2p = p2p + 4; p2ppt = p2ppt + 2;} else
//            if (card == "6 of Oils") {p2p = p2p + 5; p2ppt = p2ppt + 2;} else
//            if (card == "1 of Renewables") {p2p = p2p + 1; p2ppt = p2ppt - 1;} else
//            if (card == "2 of Renewables") {p2p = p2p + 2; p2ppt = p2ppt - 1;} else
//            if (card == "3 of Renewables") {p2p = p2p + 2; p2ppt = p2ppt - 2;} else
//            if (card == "4 of Renewables") {p2p = p2p + 3; p2ppt = p2ppt - 2;} else
//            if (card == "5 of Renewables") {p2p = p2p + 4; p2ppt = p2ppt - 2;} else
//            if (card == "6 of Renewables") {p2p = p2p + 5; p2ppt = p2ppt - 2;} else
//            if (card == "1 of Industrials") {p2p = p2p + 5; p2ppt = p2ppt + 3;} else
//            if (card == "2 of Industrials") {p2p = p2p + 6; p2ppt = p2ppt + 3;} else
//            if (card == "3 of Industrials") {p2p = p2p + 7; p2ppt = p2ppt + 4;} else
//            if (card == "4 of Industrials") {p2p = p2p + 8; p2ppt = p2ppt + 4;} else
//            if (card == "5 of Industrials") {p2p = p2p + 9; p2ppt = p2ppt + 5;} else
//            if (card == "6 of Industrials") {p2p = p2p + 10; p2ppt = p2ppt + 5;} else
//            if (card == "1 of Botany") {p2p = p2p + 5; p2ppt = p2ppt - 3;} else
//            if (card == "2 of Botany") {p2p = p2p + 6; p2ppt = p2ppt - 3;} else
//            if (card == "3 of Botany") {p2p = p2p + 7; p2ppt = p2ppt - 4;} else
//            if (card == "4 of Botany") {p2p = p2p + 8; p2ppt = p2ppt - 4;} else
//            if (card == "5 of Botany") {p2p = p2p + 9; p2ppt = p2ppt - 5;} else
//            if (card == "6 of Botany") {p2p = p2p + 10; p2ppt = p2ppt - 5;} else {Console.WriteLine(card);}
//        }
//    }
//
//    static void Win(bool trueWin)
//    {
//        if (trueWin) {
//            if (p2p < p1p)
//            {
//                if (p1ppt > p2ppt) {Console.WriteLine("Player 1 has won! They had won despite Player 2's world cleaning efforts.");}
//                else if (p1ppt < p2ppt) {Console.WriteLine("Player 1 has won! They won an astounding victory!");}
//                else if (p1ppt == p2ppt) {Console.WriteLine("Player 1 has won!");}
//                else {Console.WriteLine("{0}    {1}", p1ppt, p2ppt);}
//            }
//            else if (p1p < p2p)
//            {
//                if (p1ppt > p2ppt) {Console.WriteLine("Player 2 has won! They won an astounding victory!");}
//                else if (p1ppt < p2ppt) {Console.WriteLine("Player 2 has won! They had won despite Player 1's world cleaning efforts.");}
//                else if (p1ppt == p2ppt) {Console.WriteLine("Player 2 has won!");}
//                else {Console.WriteLine("{0}    {1}", p1ppt, p2ppt);}
//            }
//            else {Console.WriteLine("{0}    {1}", p1p, p2p);} // Error Line
//        }
//        else
//        {
//            Console.WriteLine("No Cards Left!"); // No Card Win
//            if (p1p < p2p) {Console.WriteLine("Player 1 won! They had less pollution when the cards had ran out.");}
//            if (p1p > p2p) {Console.WriteLine("Player 2 won! They had less pollution when the cards had ran out.");}
//        }
//    }
//}
//}

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
