
/*contrato autenticavel
 	Quem assinar esse contrato, precisa implementar
 		metodo senha
 		metodo autentica
*/ 
public abstract interface Autenticavel {
	
	public abstract void setSenha(int senha);
	
	public abstract boolean autentica(int senha);

}
