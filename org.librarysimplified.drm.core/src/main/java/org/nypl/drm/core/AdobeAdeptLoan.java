package org.nypl.drm.core;

import java.util.Arrays;
import java.util.Objects;
import java.io.Serializable;

/**
 * The rights associated with a fulfilled book.
 */

public final class AdobeAdeptLoan implements Serializable
{
  private final byte[]      serialized;
  private final boolean     returnable;
  private final AdobeLoanID loan;

  /**
   * Construct a set of rights.
   *
   * @param in_loan       The loan ID
   * @param in_serialized The serialized form of the rights
   * @param in_returnable {@code true} iff the loan is returnable
   */

  public AdobeAdeptLoan(
    final AdobeLoanID in_loan,
    final byte[] in_serialized,
    final boolean in_returnable)
  {
    this.loan = Objects.requireNonNull(in_loan);
    this.serialized = Objects.requireNonNull(in_serialized);
    this.returnable = in_returnable;
  }

  @Override public boolean equals(final Object o)
  {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    final AdobeAdeptLoan that = (AdobeAdeptLoan) o;
    if (this.isReturnable() != that.isReturnable()) {
      return false;
    }
    if (!Arrays.equals(this.getSerialized(), that.getSerialized())) {
      return false;
    }
    return this.getID().equals(that.getID());
  }

  @Override public String toString()
  {
    final StringBuilder sb = new StringBuilder("AdobeAdeptLoan{");
    sb.append("loan=").append(this.loan);
    sb.append(", serialized=").append(Arrays.toString(this.serialized));
    sb.append(", returnable=").append(this.returnable);
    sb.append('}');
    return sb.toString();
  }

  @Override public int hashCode()
  {
    int result = Arrays.hashCode(this.getSerialized());
    result = 31 * result + (this.isReturnable() ? 1 : 0);
    result = 31 * result + this.getID().hashCode();
    return result;
  }

  /**
   * @return The loan ID
   */

  public AdobeLoanID getID()
  {
    return this.loan;
  }

  /**
   * @return {@code true} iff the loan is returnable
   */

  public boolean isReturnable()
  {
    return this.returnable;
  }

  /**
   * @return The serialized form of the rights
   */

  public byte[] getSerialized()
  {
    return this.serialized;
  }
}
