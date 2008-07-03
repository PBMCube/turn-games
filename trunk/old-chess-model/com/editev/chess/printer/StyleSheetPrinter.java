package com.editev.chess.printer;import com.editev.chess.GameHTML;/** Prints a style sheet, if necessary.  * *  @see See the source <a href="StyleSheetPrinter.java">here</a>. */public class StyleSheetPrinter extends Printer {    /** Color of a black piece. */    public static final String BLACK_PIECE  = "#000000";    /** Color of a black square. */    public static final String BLACK_SQUARE = "#777700";    /** Color of a white piece. */    public static final String WHITE_PIECE  = "#FFFFFF";    /** Color of a white square. */    public static final String WHITE_SQUARE = "#AAAA66";    /** The color of a piece.      *     *  @return the color of a piece.      *  @param isWhite is the piece white or black?      */            private static String pieceColor(  boolean isWhite ) { return isWhite ? WHITE_PIECE  : BLACK_PIECE ; }    /** The color of a square.      *     *  @return the color of a square.      *  @param isWhite is the square white or black?      */            private static String squareColor( boolean isWhite ) { return isWhite ? WHITE_SQUARE : BLACK_SQUARE; }        /** The name of a style for a given square and piece color.      *     * @return name of the style representing that piece and square color.      */    public static String styleName( boolean isWhitePiece, boolean isWhiteSquare ) {        return             isWhitePiece ?                 (isWhiteSquare ? "whiteWhite" : "whiteBlack")              : (isWhiteSquare ? "blackWhite" : "blackBlack");    }        /** The name of a style for a captured piece.      *     * @return name of the style representing that piece and square color.      */    public static String captureStyleName( boolean isWhitePiece ) {        return  isWhitePiece ? "white" : "black";    }        /** A template for CSS styles for squares and pieces. */    private static String STYLE_TEMPLATE = "; font-size: x-large; font-family: sans-serif }\n";    /** A template for CSS styles for captured pieces.. */    private static String CAPTURE_STYLE_TEMPLATE = "; font-family: sans-serif }\n";    /** Get the CSS style definition for this piece and square color.       *     *  @return the style definition for the CSS style sheet.     */    public static String getCSSDefinition( boolean isWhitePiece, boolean isWhiteSquare ) {        return             "  ." + styleName( isWhitePiece, isWhiteSquare )           + " { color: " + pieceColor( isWhitePiece )          + "; background-color: " + squareColor( isWhiteSquare )          + STYLE_TEMPLATE;    }    /** Get the CSS style definition for captured pieces.     *     *  @return the style definition for captured pieces.     */    public static String getCaptureCSSDefinition( boolean isWhitePiece ) {        return             "  ." + captureStyleName( isWhitePiece )           + " { color: " + pieceColor( isWhitePiece )          + "; background-color: " + squareColor( !isWhitePiece )          + CAPTURE_STYLE_TEMPLATE;    }        public static final String HISTORY_STYLE_NAME = "hist";    public static final String HISTORY_STYLE = "  ."+HISTORY_STYLE_NAME +" { font-size: small; font-family: mono; color: #000000 }\n";    /** Information that needs to appear in the header of the HTML document, including CSS style sheets and Javascript. */    public static final String HEADER =         " <style type=\"text/css\">\n"      + " <!--\n\n"            + getCSSDefinition( false, false )      + getCSSDefinition( false, true  )      + getCSSDefinition( true,  false )      + getCSSDefinition( true,  true  )            + getCaptureCSSDefinition( false )      + getCaptureCSSDefinition( true  )            + HISTORY_STYLE      + "\n -->\n"            + " </style>\n\n";          public void print( GameHTML game ) {        if (!game.hasStyles) return;        game.out.print( HEADER );    }}