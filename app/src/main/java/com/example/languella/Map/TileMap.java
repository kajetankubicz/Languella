package com.example.languella.Map;

import static com.example.languella.Map.MapLayout.NUM_OF_COLUMN_TILES;
import static com.example.languella.Map.MapLayout.NUM_OF_ROW_TILES;
import static com.example.languella.Map.MapLayout.TILE_HEIGHT_PIXELS;
import static com.example.languella.Map.MapLayout.TILE_WIDTH_PIXELS;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.languella.Game1.GameDisplay;
import com.example.languella.Graphics.SpriteSheet;

/**
 * Klasa do nalozenie spite'a na kafelek
 */
public class TileMap {
    /** Atrybuty klasy */
    private final MapLayout mapLayout;
    private Tile[][] tilemap;
    private SpriteSheet spriteSheet;
    private Bitmap mapBitmap;

    /**
     * Rozmieszczenie kafelkow na mapie
     * @param spriteSheet dostep do informacji z jpeg'a
     */
    public TileMap(SpriteSheet spriteSheet){
        mapLayout = new MapLayout();
        this.spriteSheet = spriteSheet;
        initializeTileMap();
    }

    /**
     * Odczytanie tablicy z miejscami gdzie sa odpowiednie kafelki
     * Petle do rozmieszczenia kafelkow w odpowiednich miejscach
     */
    private void initializeTileMap() {
        int[][] layout = mapLayout.getLayout(); //
        tilemap = new Tile[NUM_OF_ROW_TILES][NUM_OF_COLUMN_TILES];
        for(int iRow = 0; iRow<NUM_OF_ROW_TILES; iRow++){
            for(int iCol = 0; iCol<NUM_OF_COLUMN_TILES; iCol++){
                tilemap[iRow][iCol] = Tile.getTile(
                        layout[iRow][iCol],
                        spriteSheet,
                        getRectByIndex(iRow,iCol)
                );
            }
        }

        /** Konfiguracja kolorow bitmapy */
        Bitmap.Config config = Bitmap.Config.ARGB_8888; //
        /** Tworzenie bitmapy */
        mapBitmap = Bitmap.createBitmap(
                NUM_OF_COLUMN_TILES*TILE_WIDTH_PIXELS,
                NUM_OF_ROW_TILES*TILE_HEIGHT_PIXELS,
                config
        );

        Canvas mapCanvas = new Canvas(mapBitmap);

        /** Rysowanie kafelkow na bitmapie */
        for(int iRow = 0; iRow<NUM_OF_ROW_TILES; iRow++){
            for(int iCol = 0; iCol<NUM_OF_COLUMN_TILES; iCol++){

                tilemap[iRow][iCol].draw(mapCanvas);
            }
        }
    }

    /**
     * Rozmieszanie kafelkow
     * @param idRow numer rzedu
     * @param idCol numer kolumny
     * @return
     */
    private Rect getRectByIndex(int idRow, int idCol) {
        return new Rect(
                idCol*TILE_WIDTH_PIXELS,
                idRow*TILE_HEIGHT_PIXELS,
                (idCol+1)*TILE_WIDTH_PIXELS,
                (idRow+1)*TILE_HEIGHT_PIXELS
        );
    }

    /**
     * Metoda do rysowania
     * @param canvas dostep do informacji o stanie aplikacji
     * @param gameDisplay dostep do informacji gdzie rysowac na mapie
     */
    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        canvas.drawBitmap(
                mapBitmap,
                gameDisplay.getGameRect(),
                gameDisplay.DISPLAY_RECT,
                null
        );
    }
}
