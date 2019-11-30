package _rejected;

import javax.swing.*;

import static gui.MainFrame.*;

public class Layer_2 {

    private static JPanel panel2;
    private static JPanel panel2Left = new JPanel();
    private static JPanel panel2Right = new JPanel();
    int[] panel2LeftBounds = {
            tile >> 5,
            tile >> 5,
            tile_x - (tile_x >> 2) - (tile >> 3) - (tile >> 5),
            tile_y - (tile >> 3) + (tile >> 5)
    };
    int[] panel2RightBounds = {
            tile_x - (tile_x >> 2) - (tile >> 3),
            tile >> 5,
            (tile_x >> 2) + (tile >> 3),
            tile_y - (tile >> 3) + (tile >> 5)
    };
    private int cardId = 0;

/*    public Layer_2() {
        panel2 = new JPanel();
        panel2.setOpaque(false);
        panel2.setBounds(0, 0, tile_x, tile_y);
        panel2.setLayout(null);

        {
            panel2Left.setBounds(panel2LeftBounds[0], panel2LeftBounds[1], panel2LeftBounds[2], panel2LeftBounds[3]);
            panel2Left.setLayout(new GridLayout(cardGridSize[0], cardGridSize[1]));
            panel2Left.setOpaque(false);
            makeCardLabels();
            panel2.add(panel2Left);
        }

        {
            panel2Right.setBounds(panel2RightBounds[0], panel2RightBounds[1], panel2RightBounds[2], panel2RightBounds[3]);
            panel2Right.setLayout(null);
            panel2Right.setOpaque(false);
            panel2.add(panel2Right);
        }
    }*/

    public static JPanel makeLayer_2() {
        new Layer_2();
        return panel2;
    }

    public void makeCardLabels() {
        Random random = new Random();

        for (int i = 0; i < cardGridSize[0] * cardGridSize[1]; i++) {

            int size_x = panel2LeftBounds[2] / cardGridSize[0];
            int size_y = panel2LeftBounds[3] / cardGridSize[1];
            int rescale = (size_x / size_y) > 1 ? size_y : size_x;

            if (i % 2 == 0) {
                getCardsList().addCardToList(new Card(
                        getCardGraphicsLists().getFrontImagesList().get(i / 2).getScaledInstance(
                                rescale - (rescale >> 2),
                                rescale - (rescale >> 2),
                                Image.SCALE_SMOOTH),
                        getCardGraphicsLists().getCoverImagesList().get(random.nextInt(4)).getScaledInstance(rescale - (rescale >> 2), rescale - (rescale >> 2), Image.SCALE_SMOOTH),
                        cardId,
                        new JButton(),
                        new JLabel()));
                cardId += 1;
            } else {
                getCardsList().addCardToList(new Card(
                        getCardGraphicsLists().getFrontImagesList().get(i / 2).getScaledInstance(rescale - (rescale >> 2),
                                rescale - (rescale >> 2),
                                Image.SCALE_SMOOTH),
                        getCardGraphicsLists().getCoverImagesList().get(random.nextInt(4)).getScaledInstance(rescale - (rescale >> 2),
                                rescale - (rescale >> 2),
                                Image.SCALE_SMOOTH),
                        getCardsList().getCardFromList(i - 1).getCardId(),
                        new JButton(),
                        new JLabel()));
            }
            getCardsList().getCardFromList(i).getjLabel().setIcon(new ImageIcon(getCardsList().getCardFromList(i).getBack()));
        }
        Collections.shuffle(getCardsList().getCardsList());

        for (int i = 0; i < cardGridSize[0] * cardGridSize[1]; i++) {
            panel2Left.add(getCardsList().getCardFromList(i).getjLabel());
        }
    }
}

