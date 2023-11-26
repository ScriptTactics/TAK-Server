//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2017.10.03 at 02:27:05 PM EDT
//


package com.bbn.marti.excheck.checklist;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for checklist complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * {@code
 * &lt;complexType name="checklist">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="checklistDetails" type="{}checklistDetails"/>
 *         &lt;element name="checklistColumns" type="{}checklistColumns"/>
 *         &lt;element name="checklistTasks" type="{}checklistTasks"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * }
 * </pre>
 *
 *
 */
@XmlRootElement(name = "checklist")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checklist", propOrder = {
    "checklistDetails",
    "checklistColumns",
    "checklistTasks"
})
public class Checklist {

    @XmlElement(required = true)
    protected ChecklistDetails checklistDetails;
    @XmlElement(required = true)
    protected ChecklistColumns checklistColumns;
    @XmlElement(required = true)
    protected ChecklistTasks checklistTasks;

    /**
     * Gets the value of the checklistDetails property.
     *
     * @return
     *     possible object is
     *     {@link ChecklistDetails }
     *
     */
    public ChecklistDetails getChecklistDetails() {
        return checklistDetails;
    }

    /**
     * Sets the value of the checklistDetails property.
     *
     * @param value
     *     allowed object is
     *     {@link ChecklistDetails }
     *
     */
    public void setChecklistDetails(ChecklistDetails value) {
        this.checklistDetails = value;
    }

    /**
     * Gets the value of the checklistColumns property.
     *
     * @return
     *     possible object is
     *     {@link ChecklistColumns }
     *
     */
    public ChecklistColumns getChecklistColumns() {
        return checklistColumns;
    }

    /**
     * Sets the value of the checklistColumns property.
     *
     * @param value
     *     allowed object is
     *     {@link ChecklistColumns }
     *
     */
    public void setChecklistColumns(ChecklistColumns value) {
        this.checklistColumns = value;
    }

    /**
     * Gets the value of the checklistTasks property.
     *
     * @return
     *     possible object is
     *     {@link ChecklistTasks }
     *
     */
    public ChecklistTasks getChecklistTasks() {
        return checklistTasks;
    }

    /**
     * Sets the value of the checklistTasks property.
     *
     * @param value
     *     allowed object is
     *     {@link ChecklistTasks }
     *
     */
    public void setChecklistTasks(ChecklistTasks value) {
        this.checklistTasks = value;
    }

}
