package Bridge;

abstract class Remote{
    Device device;

    public Remote(Device device){
        this.device = device;
    }

    public void setVolume(int volume) {
        System.out.println("The volume is set to:" + volume);
        this.device.setVolume(volume);
    }

    public void setChnnel(int chanel) {
        System.out.println("The channel is set to: "+ chanel);
        this.device.setChannel(chanel);
    }

    void powerOn(){
        this.device.getInformation();
        System.out.println("Power On");
    };
    void volumeUp(){
        this.device.setVolume(this.device.getVolume()+1);
        System.out.println("volume is: " + (this.device.getVolume()));
    };
    void volumeDown(){
        this.device.setVolume(this.device.getVolume()-1);
        System.out.println("volume is: " + (this.device.getVolume()));
    };
    void ChannelUp(){
        this.device.setChannel(this.device.getChannel()+1);
        System.out.println("Channel is : "+ (this.device.getChannel()));
    };
    void ChannelDown(){
        this.device.setChannel(this.device.getChannel()-1);
        System.out.println("Channel is: "+ (this.device.getChannel()));
    };
    abstract void getChannel();
    abstract void getVolume();
    abstract void mute();
}
class App extends Remote{

    public App(Device device) {
        super(device);
    }

    @Override
    void getChannel() {
        System.out.println("channel is: " + (this.device.getChannel()));
    }

    @Override
    void getVolume() {
        System.out.println("volume is: " + (this.device.getVolume()));
    }

    @Override
    void mute() {

    }
}

class web extends Remote{

    public web(Device device) {
        super(device);
    }

    @Override
    void getChannel() {
        System.out.println("Channel is: " + (this.device.getChannel()));
    }

    @Override
    void getVolume() {
        System.out.println("volume is: " + (this.device.getVolume()));
    }

    @Override
    void mute() {

        this.device.setVolume(0);
    }
}

interface Device{
    int getChannel();
    int getVolume();
    void setChannel(int channel);
    void setVolume(int volume);
    void getInformation();
}

class TV implements Device{
    static int channel;
    static int volume;
    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void getInformation() {
        System.out.println("This is TV");
    }
}

class Radio implements Device{
    static int channel;
    static int volume;
    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void getInformation() {
        System.out.println("This is Radio");
    }
}


public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        Remote remote1 = new App(tv);
        Remote remote2 = new App(new Radio());
        Remote remote3 =new web(tv);

        remote1.powerOn();
        remote1.setChnnel(2);
        remote1.setVolume(50);
        remote1.ChannelUp();
        remote1.volumeUp();

        remote2.powerOn();
        remote2.setChnnel(6);
        remote2.setVolume(20);
        remote2.volumeDown();
        remote2.ChannelDown();

        remote3.powerOn();
        remote3.getVolume();
        remote3.mute();
        remote3.getVolume();


    }
}
