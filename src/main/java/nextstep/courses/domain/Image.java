package nextstep.courses.domain;

public class Image {

    public static final int MAXIMUM_SIZE = 1024 * 1024;
    public static final int MINIMUM_WIDTH = 300;
    public static final int MINIMUM_HEIGHT = 200;
    public static final int RATE_BETWEEN_WIDTH_AND_HEIGHT = 3 / 2;
    public static final String RATE_STRING_BETWEEN_WIDTH_AND_HEIGHT = "3:2";
    public static final String 이미지_크기는_D_이하여야_합니다_현재_사이즈_D = "이미지 크기는 %d 이하여야 합니다. 현재 사이즈 : %d";
    public static final String 이미지의_가로는_DPX_이상이어야_합니다_현재_가로_D = "이미지의 가로는 %dpx 이상이어야 합니다. 현재 가로 : %d";
    public static final String 이미지의_세로는_D_이상이어야_합니다_현재_세로_D = "이미지의 세로는 %d 이상이어야 합니다. 현재 세로 : %d";
    private final String path;
    private final int size;
    private final ImageType imageType;

    public Image(String path, int width, int height, ImageType imageType) {

        inputValidation(width, height, imageType);
        this.path = path;
        this.size = width * height;
        this.imageType = imageType;
    }

    private void inputValidation(int width, int height, ImageType imageType) {
        if (width * height > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(String.format(이미지_크기는_D_이하여야_합니다_현재_사이즈_D, MAXIMUM_SIZE, width * height));
        }

        if(width < MINIMUM_WIDTH){
            throw new IllegalArgumentException(String.format(이미지의_가로는_DPX_이상이어야_합니다_현재_가로_D, MINIMUM_WIDTH, width));
        }

        if(height < MINIMUM_HEIGHT){
            throw new IllegalArgumentException(String.format(이미지의_세로는_D_이상이어야_합니다_현재_세로_D, MINIMUM_HEIGHT, height));
        }

        if(width/height != RATE_BETWEEN_WIDTH_AND_HEIGHT){
            throw new IllegalArgumentException(String.format("이미지의 가로 세로 비율은 %s 여야 합니다. 현재 비율 : %d:%d",RATE_STRING_BETWEEN_WIDTH_AND_HEIGHT, width, height));
        }

    }

}
