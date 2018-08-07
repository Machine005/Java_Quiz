
public class waveform {
	private static long counter;
	private final long id=counter++;
	public String toString(){ return getClass().getSimpleName();}
}

 class Filter{
	public String name(){
		return getClass().getSimpleName();
	}
	public waveform process(waveform input){ return input;}
}

 class LowPass extends Filter{
	double cutoff;
	public LowPass(double cutoff){this.cutoff=cutoff;}
	public waveform process(waveform input){ return input;}
}

 class HighPass extends Filter{
	double cutoff;
	public HighPass(double cutoff){this.cutoff=cutoff;}
	public waveform process(waveform input){ return input;}
}

 class BandPass extends Filter{
	double lowCutoff, highCutoff;
	public BandPass(double lowcut,double hightcut){
		highCutoff=hightcut;
		lowCutoff=lowcut;
	}
	public waveform process(waveform input){ return input;}
}