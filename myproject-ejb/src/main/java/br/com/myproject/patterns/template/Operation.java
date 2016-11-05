package br.com.myproject.patterns.template;

public interface Operation {
	
	public abstract void process();
	
	public abstract void preProcessing();
	
	public abstract void postProcessing();
}
