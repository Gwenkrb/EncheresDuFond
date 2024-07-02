package fr.eni.encheresdufond.dal;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.eni.encheresdufond.bo.Utilisateur;


@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO {
	// Création d'un attribut JDBC Template
	private NamedParameterJdbcTemplate jdbcTemplate;

	private static final String CREATE_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (:pseudo, :nom, :prenom, :email, :telephone, :rue, :code_postal, :ville, :mot_de_passe, :credit, :administrateur)";
	private static final String FIND_BY_PSEUDO = "SELECT pseudo, mot_de_passe FROM UTILISATEURS WHERE pseudo = :pseudo";
	private static final String FIND_ALL = "SELECT * FROM UTILISATEURS";

	/**
	 * @param jdbcTemplate
	 */
	public UtilisateurDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @param no_utilisateur extraire utilisateur by id
	 */
	@Override
	public Utilisateur read(String pseudo) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("pseudo", pseudo);
		return jdbcTemplate.queryForObject(FIND_BY_PSEUDO, namedParameters, new BeanPropertyRowMapper<>(Utilisateur.class));
	}
	
	@Override
	public List<Utilisateur> findAll() {

		return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Utilisateur.class));
	}

	@Override
	public void creer(Utilisateur utilisateur) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		namedParameters.addValue("pseudo", utilisateur.getPseudo());
		namedParameters.addValue("nom", utilisateur.getNom());
		namedParameters.addValue("prenom", utilisateur.getPrenom());
		namedParameters.addValue("email", utilisateur.getEmail());
		namedParameters.addValue("telephone", utilisateur.getTelephone());
		namedParameters.addValue("rue", utilisateur.getRue());
		namedParameters.addValue("code_postal", utilisateur.getCodePostale());
		namedParameters.addValue("ville", utilisateur.getVille());
		namedParameters.addValue("mot_de_passe", utilisateur.getMotDePasse());
		namedParameters.addValue("credit", utilisateur.getCredit());
		namedParameters.addValue("administrateur", utilisateur.isAdminisatrateur());
		
		jdbcTemplate.update(CREATE_UTILISATEUR, namedParameters, keyHolder);
		
		if (keyHolder != null && keyHolder.getKey() != null) {
			utilisateur.setNoUtilisateur(keyHolder.getKey().longValue());
		}
		
	}

	

}
