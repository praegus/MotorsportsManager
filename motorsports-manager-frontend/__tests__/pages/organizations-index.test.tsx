import { expect, test } from 'vitest'
import { render, screen } from '@testing-library/react'
import Organization from '../../src/pages/profiles/[profileName]/organizations/[organizationName]/index'
import { vi } from "vitest";

const mockPush = vi.fn();

vi.mock("next/router", () => {
  return {
    useRouter: () => ({
      push: mockPush,
      query: {
        profileName: 'Fin',
        organizationName: 'blaat'
      }
    }),
  };
});

test('Organization', () => {
  render(<Organization />)
  expect(screen.getByTestId('profileGreeter').textContent).toContain('Welcome! Fin')
  expect(screen.getByTestId('organizationGreeter').textContent).toContain('Organization: blaat')
})