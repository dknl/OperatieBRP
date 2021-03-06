/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at www.github.com/MinBZK/operatieBRP.
 */

package nl.bzk.algemeenbrp.dal.domein.brp.entity;

import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import nl.bzk.algemeenbrp.dal.domein.brp.util.ValidationUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NamedQuery;

/**
 * The persistent class for the srtpartij database table.
 *
 */
@Entity
@EntityListeners(GegevenInOnderzoekListener.class)
@Table(name = "vertalingbersrtbrp", schema = "kern")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name = "VertalingBerichtsoortBrp" + Constanten.ZOEK_ALLES_VOOR_CACHE, query = "from VertalingBerichtsoortBrp")
public class VertalingBerichtsoortBrp extends AbstractEntiteit implements Serializable, DynamischeStamtabelMetGeldigheid {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "vertalingbersrtbrp_id_generator", sequenceName = "kern.seq_vertalingbersrtbrp", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vertalingbersrtbrp_id_generator")
    @Column(updatable = false, nullable = false)
    private Short id;

    @Column(nullable = false, length = 80, unique = true)
    private String naam;

    @Column(nullable = false, length = 250)
    private String omschrijving;

    @Column(name = "dataanvgel")
    private Integer datumAanvangGeldigheid;

    @Column(name = "dateindegel")
    private Integer datumEindeGeldigheid;

    /**
     * JPA no-args constructor.
     */
    protected VertalingBerichtsoortBrp() {}

    /**
     * Maak een nieuwe soort partij.
     *
     * @param naam naam
     */
    public VertalingBerichtsoortBrp(final String naam) {
        setNaam(naam);
    }

    /*
     * (non-Javadoc)
     *
     * @see nl.bzk.algemeen.dal.domein.brp.kern.entity.DeltaEntiteit#getId()
     */
    @Override
    public Short getId() {
        return id;
    }

    /**
     * Zet de waarden voor id.
     *
     * @param id de nieuwe waarde voor id
     */
    public void setId(final Short id) {
        this.id = id;
    }

    /**
     * Geef de waarde van naam.
     *
     * @return de waarde van naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Zet de waarden voor naam.
     *
     * @param naam de nieuwe waarde voor naam
     */
    public void setNaam(final String naam) {
        ValidationUtils.controleerOpNullWaarden("naam mag niet null zijn", naam);
        ValidationUtils.controleerOpLegeWaarden("naam mag geen lege string zijn", naam);
        this.naam = naam;
    }

    /**
     * Geef de omschrijving.
     *
     * @return de omschrijving
     */
    public String getOmschrijving() {
        return omschrijving;
    }

    /**
     * Zet de omschrijving.
     *
     * @param omschrijving de nieuwe waarde voor omschrijving
     */
    public void setOmschrijving(final String omschrijving) {
        ValidationUtils.controleerOpNullWaarden("omschrijving mag niet null zijn", naam);
        ValidationUtils.controleerOpLegeWaarden("omschrijving mag geen lege string zijn", naam);
        this.omschrijving = omschrijving;
    }

    /**
     * Geef de waarde van datum aanvang geldigheid.
     *
     * @return de waarde van datum aanvang geldigheid
     */
    @Override
    public Integer getDatumAanvangGeldigheid() {
        return datumAanvangGeldigheid;
    }

    /**
     * Zet de waarden voor datum aanvang geldigheid .
     *
     * @param datumAanvangGeldigheid de nieuwe waarde voor datum aanvang geldigheid
     */
    public void setDatumAanvangGeldigheid(final Integer datumAanvangGeldigheid) {
        this.datumAanvangGeldigheid = datumAanvangGeldigheid;
    }

    /**
     * Geef de waarde van datum einde geldigheid.
     *
     * @return de waarde van datum einde geldigheid
     */
    @Override
    public Integer getDatumEindeGeldigheid() {
        return datumEindeGeldigheid;
    }

    /**
     * Zet de waarden voor datum einde geldigheid.
     *
     * @param datumEindeGeldigheid de nieuwe waarde voor datum einde geldigheid
     */
    public void setDatumEindeGeldigheid(final Integer datumEindeGeldigheid) {
        this.datumEindeGeldigheid = datumEindeGeldigheid;
    }
}
