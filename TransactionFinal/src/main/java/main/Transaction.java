package main;
import java.util.Date;


import java.text.SimpleDateFormat;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Transaction {
	@Id
	String Ref;
	String CompteDeb;
	String CompteCred;
	double Montant;
	String Devise;
	String Type;
	String Date;
	
	@Override
	public int hashCode() {
		return Objects.hash(CompteCred, CompteDeb, Devise, Montant, Ref, Type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(CompteCred, other.CompteCred) && Objects.equals(CompteDeb, other.CompteDeb)
				&& Objects.equals(Devise, other.Devise) && Montant == other.Montant && Objects.equals(Ref, other.Ref)
				&& Objects.equals(Type, other.Type);
	}
	public String getRef() {
		return Ref;
	}
	public void setRef(String ref) {
		Ref = ref;
	}
	public String getCompteDeb() {
		return CompteDeb;
	}
	public void setCompteDeb(String compteDeb) {
		CompteDeb = compteDeb;
	}
	public String getCompteCred() {
		return CompteCred;
	}
	public void setCompteCred(String compteCred) {
		CompteCred = compteCred;
	}
	public String getDevise() {
		return Devise;
	}
	public void setDevise(String devise) {
		Devise = devise;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public double getMontant() {
		return Montant;
	}
	public void setMontant(double montant) {
		Montant = montant;
	}
	public String getDate() {
		return Date;
	}
	public Transaction(){
	Date d  = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	this.Date = sdf.format(d);
}
}