import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz !");
        Player player = new Player("Cihat");
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli adaya hoşgeldin !! Burada yaşananların hepsi gerçek !");
        System.out.println("*** Karakterler ***");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
                System.out.println("########## Bölgeler ##########");
            System.out.println();
                System.out.println("1 - Güvenli Ev --> Burası sizin için güvenli bir ev, düşman yoktur !");
                System.out.println("2 - Mağaza --> Silah veya Zırh satın alabilirsiniz !");
                System.out.println("0 - Çıkış yap --> Oyunu sonlandır !");
                System.out.println("Lütfen gitmek istediğiniz bölgeyi seçini : ");
                int selectLoc = input.nextInt();
                switch (selectLoc) {
                    case 0:
                        location = null;
                        break;
                    case 1:
                        location = new SafeHouse(player);
                        break;
                    case 2:
                        location = new ToolStore(player);
                        break;
                    default:
                        location = new SafeHouse(player);
                }

                if(location == null){
                    System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin !");
                    break;
                }

                if (!location.onLocation()) {
                    System.out.println("GAME OVER !");
                    break;
                }
            }
        }
    }

