package fr.eni.encheresdufond.dal;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.encheresdufond.bo.Utilisateur;


@Repository
public class UtilisateurDAOImpl implements UtilisateurDAO {
	// Création d'un attribut JDBC Template
	private NamedParameterJdbcTemplate jdbcTemplate;

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

	

}
